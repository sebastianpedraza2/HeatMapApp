package com.example.pruebatecnicasebastianpedraza.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.example.pruebatecnicasebastianpedraza.core.Resource
import com.example.pruebatecnicasebastianpedraza.repository.HeatMapRepo
import com.example.pruebatecnicasebastianpedraza.repository.HeatMapRepoImpl
import kotlinx.coroutines.Dispatchers

class HeatMapViewModel(private val heatMapRepo: HeatMapRepo) : ViewModel() {
    fun fetchProjects() = liveData(Dispatchers.IO) {
        emit(Resource.Loading())
        try {
            emit(heatMapRepo.getProjects())
        } catch (e: Exception) {
            emit(Resource.Failure(e))
        }

    }
}

class HeatMapViewModelFactory(private val heatMapRepo: HeatMapRepo) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(HeatMapRepo::class.java).newInstance(heatMapRepo)
    }

}