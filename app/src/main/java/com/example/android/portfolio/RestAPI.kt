package com.example.android.portfolio

import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Artur on 20-Dec-16.
 */
class RestAPI {
    private val gitHubService: GitHubService

    init {
        val retrofit = Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        gitHubService = retrofit.create(GitHubService::class.java)
    }
    fun getProjects(name: String): Call<List<Project>> {return gitHubService.getRepos(name)}
}
