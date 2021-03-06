package com.github.trendrepo.network

import com.github.trendrepo.room.Repository
import io.reactivex.Observable
import retrofit2.http.GET

interface RepositoryApi {

    @GET("/repositories")
    fun getRepositories(): Observable<List<Repository>>
}