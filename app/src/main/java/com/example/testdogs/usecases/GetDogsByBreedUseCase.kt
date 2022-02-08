package com.example.testdogs.usecases

import android.util.Log
import com.example.testdogs.data.DogRepository
import com.example.testdogs.domain.model.DogList
import javax.inject.Inject

class GetDogsByBreedUseCase @Inject constructor(
    private val repository: DogRepository
){
    /** usando fun invoke **/
//    suspend operator fun invoke():DogList{
    suspend fun getDogListByBreed(breed: String):DogList{
        Log.i("GetDogsByBreedUseCase", "entrando al invoke")
        return repository.getAllDogsFromRemote(breed)
    }
}