package com.mcmouse88.breakingbad_api.data.network

import com.mcmouse88.breakingbad_api.domain.models.Character
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("characters")
    suspend fun getAllCharacters(): Response<List<Character>>
}