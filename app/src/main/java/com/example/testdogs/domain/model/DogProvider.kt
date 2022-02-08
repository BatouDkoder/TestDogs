package com.example.testdogs.domain.model

import java.lang.Exception
import javax.inject.Inject


class DogProvider @Inject constructor() {
    var breedList: DogList = DogList(mutableMapOf())

    fun findBreed(breed:String, dog:DogList=this.breedList):Boolean{
        return try {
            dog.dogs.getValue(breed).isNotEmpty()
        }
        catch (e:Exception){
            return false
        }
    }
}


/**
 *
data class DogModel(val url: String)
data class Breed(val breed:String)
class DogProvider {
var breedList: MutableMap<Breed,List<DogModel>> = mutableMapOf()
}

fun main(){
val dogProvider = DogProvider()


dogProvider.breedList = mutableMapOf(Breed("labrador") to
mutableListOf(DogModel("url1"), DogModel("url2"), DogModel("url3")))

dogProvider.breedList += mutableMapOf(Breed("pequines") to
mutableListOf(DogModel("url4"), DogModel("url5"), DogModel("url6")))

print(dogProvider.breedList)
}
 **/