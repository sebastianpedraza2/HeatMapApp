package com.example.pruebatecnicasebastianpedraza.repository

import com.example.pruebatecnicasebastianpedraza.core.Resource
import com.example.pruebatecnicasebastianpedraza.data.model.Project
import com.example.pruebatecnicasebastianpedraza.data.remote.HeatMapDataSource

class HeatMapRepoImpl(private val heatMapDataSource: HeatMapDataSource) : HeatMapRepo {
    override suspend fun getProjects(): Resource<List<Project>> = heatMapDataSource.getProjects()
}