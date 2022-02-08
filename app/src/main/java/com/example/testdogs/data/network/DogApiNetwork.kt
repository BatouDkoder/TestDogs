package com.example.testdogs.data.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface DogApiNetwork{
    @GET ("{breed}/images")
    suspend fun getDogByBreed(@Path("breed") breed: String) : Response<DogResponse>
}