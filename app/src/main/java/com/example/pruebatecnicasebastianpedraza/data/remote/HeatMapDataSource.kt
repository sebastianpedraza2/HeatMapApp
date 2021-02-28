package com.example.pruebatecnicasebastianpedraza.data.remote

import android.util.Log
import com.example.pruebatecnicasebastianpedraza.core.Resource
import com.example.pruebatecnicasebastianpedraza.data.model.Project
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

class HeatMapDataSource {
    suspend fun getProjects(): Resource<List<Project>> {
        val projectsList = mutableListOf<Project>()
        val querySnapshot = FirebaseFirestore.getInstance().collection("projects").get().await()

        for (project in querySnapshot.documents) {
            project.toObject(Project::class.java)?.let { project ->
                projectsList.add(project)
            }
        }

        Log.d("Firebase1", "getLatestprojects: $projectsList")
        return Resource.Success(projectsList)
    }
}