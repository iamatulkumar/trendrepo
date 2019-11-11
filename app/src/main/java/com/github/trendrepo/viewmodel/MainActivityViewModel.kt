package com.github.trendrepo.viewmodel

import android.view.Gravity
import android.view.MenuItem
import android.view.View
import androidx.appcompat.widget.PopupMenu
import com.github.trendrepo.R
import com.github.trendrepo.base.BaseViewModel
import com.github.trendrepo.network.RepositoryApi
import com.github.trendrepo.room.Repository
import com.github.trendrepo.room.RepositoryDao
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainActivityViewModel(private val repositoryDao: RepositoryDao) : BaseViewModel() {

    @Inject
    lateinit var repositoryApi: RepositoryApi

    private lateinit var subscription: Disposable

    init {
        loadRepositories()
    }

    private fun loadRepositories() {
        subscription = Observable.fromCallable { repositoryDao.all }
            .concatMap { dbRepositoryList ->
                repositoryApi.getRepositories().concatMap { apiRepositoryList ->
                    repositoryDao.insertAll(*apiRepositoryList.toTypedArray())
                    Observable.just(apiRepositoryList)
                }
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { onRetrievePostListStart() }
            .doOnTerminate { onRetrievePostListFinish() }
            .subscribe(
                { result -> onRetrievePostListSuccess(result) },
                { onRetrievePostListError() }
            )
    }

    private fun onRetrievePostListStart() {

    }

    private fun onRetrievePostListFinish() {

    }

    private fun onRetrievePostListSuccess(repositoryList: List<Repository>) {

    }

    private fun onRetrievePostListError() {
    }

    fun onClickToolBarMenu(v: View) {
        showFilterPopup(v)
    }

    private fun showFilterPopup(v: View) {
        val popup = PopupMenu(v.context, v, Gravity.END, 0, R.style.OverflowMenu)
        popup.inflate(R.menu.menu_main)

        popup.setOnMenuItemClickListener(object : PopupMenu.OnMenuItemClickListener {
            override fun onMenuItemClick(item: MenuItem): Boolean {
                when (item.getItemId()) {
                    else -> return false
                }
            }
        })

        popup.show()

    }

    override fun onCleared() {
        super.onCleared()
        subscription.dispose()
    }

}