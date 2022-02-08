package com.example.testdogs.utils

import com.example.testdogs.data.network.DogResponse
import com.example.testdogs.domain.model.DogList
import java.lang.Exception

fun fromDogResponseToDogItem(breed:String, listDogs:DogResponse): DogList {
    return DogList(dogs= mutableMapOf(breed to listDogs.images))?: DogList(mutableMapOf())
}

fun getListByBreed(breed: String,listDogs: DogList):List<String>{
    return listDogs.dogs.getValue(breed) ?: emptyList()
}