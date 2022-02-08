package com.example.testdogs.data

import android.util.Log
import com.example.testdogs.data.database.dao.DogDao
import com.example.testdogs.data.network.DogServiceNetwork
import com.example.testdogs.domain.model.DogList
import com.example.testdogs.domain.model.DogProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception
import javax.inject.Inject

class DogRepository @Inject constructor(
    private val service: DogServiceNetwork,
    private val dao: DogDao,
    private val dogProvider: DogProvider
) {

    suspend fun getAllDogsFromRemote(breed: String):DogList{
        Log.i("DogRepository", "la raza es: $breed")
        return withContext(Dispatchers.IO){
            if(!dogProvider.findBreed(breed)){
                Log.i("DogRepository","es nulo o empty")
                try{
                    val response:DogList = service.getAllDogs(breed)
                    dogProvider.breedList[breed]= response
                }
                catch (e:Exception){
                    DogList(mutableMapOf())
                }
            }
            try {
                Log.i("DogRepository","Paso al try, es decir existe el breed en el dogProvider")
                dogProvider.breedList[breed]
            }
            catch (e:Exception){
                Log.i("DogRepository","aADDSADSASDASDSA")
                DogList(mutableMapOf())
            }
        }
    }
}