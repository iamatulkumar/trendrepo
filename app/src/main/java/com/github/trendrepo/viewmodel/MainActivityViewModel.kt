package com.github.trendrepo.viewmodel

import com.github.trendrepo.base.BaseViewModel
import com.github.trendrepo.network.RepositoryApi
import com.github.trendrepo.room.RepositoryDao
import javax.inject.Inject

class MainActivityViewModel(private val repositoryDao: RepositoryDao) : BaseViewModel() {

    @Inject
    lateinit var repositoryApi: RepositoryApi

    init {

    }
}