package com.github.trendrepo.network

import com.github.trendrepo.room.Repository
import io.reactivex.Observable
import retrofit2.http.GET

interface PostApi {

    @GET("/repositories")
    fun getPosts(): Observable<List<Repository>>
}