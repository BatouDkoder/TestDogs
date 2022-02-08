package com.example.testdogs.data.network

import com.squareup.moshi.Json

data class DogResponse(
    @Json(name = "message")
    var images:List<String>
)
