package com.example.android.portfolio

import android.util.Log

/**
 * Created by Artur on 20-Dec-16.
 */

class ProjectsManager(private val api: RestAPI = RestAPI()) {
    fun getProjects(name: String = "DuralArtur"): List<Project> {
        val response = api.getProjects(name).execute()
//        if (response.isSuccessful) {
            return response.body()}
//        else {

//        }

//            Log.v("co tam", "elo")
//            return projects.map {
//                val item = Project(it.name,it.description,it.created_at,it.url)
//            }
        }
//    }
//}

