package com.example.testdogs.data.network

import android.util.Log
import com.example.testdogs.domain.model.DogList
import com.example.testdogs.utils.fromDogResponseToDogItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception
import javax.inject.Inject

class DogServiceNetwork @Inject constructor(
    private val api: DogApiNetwork
){
    suspend fun getAllDogs(breed: String): DogList {
        return withContext(Dispatchers.IO){
            Log.i("DogServiceNetwork","antes del llamado al api")
            try {
                val response = api.getDogByBreed(breed)
                Log.i("DogServiceNetwork",response.toString())
                fromDogResponseToDogItem(breed,response.body()!!)
            }
            catch (e:Exception){
                Log.i("DogServiceNetwork","NoT FOUND")
                val response = DogList(mutableMapOf())
                response
            }
        }
    }
}