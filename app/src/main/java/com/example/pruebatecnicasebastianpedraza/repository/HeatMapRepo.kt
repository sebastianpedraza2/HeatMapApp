package com.example.pruebatecnicasebastianpedraza.repository

import com.example.pruebatecnicasebastianpedraza.core.Resource
import com.example.pruebatecnicasebastianpedraza.data.model.Project

interface HeatMapRepo {
    suspend fun getProjects(): Resource<List<Project>>
}