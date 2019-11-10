package com.github.trendrepo.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Repository(@field:PrimaryKey(autoGenerate = true)
                      val id: Int,
                      val author:String,
                      val name:String,
                      val avatar:String,
                      val description:String,
                      val language:String? = "language",
                      val languageColor:String? ="#000000",
                      val stars:String,
                      val forks:String,
                      val currentPeriodStars: String)