package com.github.trendrepo.injection

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.github.trendrepo.databinding.ActivityMainBinding
import com.github.trendrepo.room.AppDatabase
import com.github.trendrepo.viewmodel.MainActivityViewModel

class ViewModelFactory(
    private val activity: AppCompatActivity,
    private val binding: ActivityMainBinding
): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainActivityViewModel::class.java)) {
            val db = Room.databaseBuilder(activity.applicationContext, AppDatabase::class.java, "posts").build()
            @Suppress("UNCHECKED_CAST")
            return MainActivityViewModel(db.repositoryDao(), binding) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")

    }
}