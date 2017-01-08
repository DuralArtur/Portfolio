package com.example.android.portfolio

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.Call

/**
 * Created by Artur on 20-Dec-16.
 */
interface GitHubService {
    @GET("users/{user}/repos?sort=created")
    fun getRepos(@Path("user") user: String): Call<List<Project>>
}