package com.mcmouse88.breakingbad_api.presentation

import com.mcmouse88.breakingbad_api.data.network.ApiService
import javax.inject.Inject

class ApiRepository @Inject constructor(private val apiService: ApiService) {

    suspend fun getAllCharacters() = apiService.getAllCharacters()
}