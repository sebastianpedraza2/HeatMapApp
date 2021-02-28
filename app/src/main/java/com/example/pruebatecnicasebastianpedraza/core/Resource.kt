package com.example.pruebatecnicasebastianpedraza.core

import java.lang.Exception

//Defines the states for the fetching process
sealed class Resource<out T> {
    class Loading<out T> : Resource<T>()
    data class Success<out T>(val data: T) : Resource<T>()
    data class Failure(val exception: Exception) : Resource<Nothing>()
}
