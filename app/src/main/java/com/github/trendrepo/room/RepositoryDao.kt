package com.github.trendrepo.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface RepositoryDao {

    @get:Query("SELECT * FROM repository")
    val all: List<Repository>

    @Insert
    fun insertAll(vararg posts: Repository)
}