package com.github.trendrepo.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Repository::class), version = 1)
abstract class AppDatabase : RoomDatabase()  {
    abstract fun repository(): RepositoryDao
}