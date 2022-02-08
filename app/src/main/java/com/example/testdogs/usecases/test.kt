package com.example.testdogs.usecases
//
//data class DogModel(val url: String)
//data class Breed(val breed:String)
//
//class DogProvider {
//    var breedList: MutableMap<Breed,List<DogModel>> = mutableMapOf()
//}
//
//fun main(){
//    val dogProvider = DogProvider()
//
//
//    dogProvider.breedList = mutableMapOf(Breed("labrador") to
//            listOf(DogModel("url1"), DogModel("url2"), DogModel("url3")))
//
//    dogProvider.breedList += mutableMapOf(Breed("pequines") to
//            listOf(DogModel("url4"), DogModel("url5"), DogModel("url6")))
//
//    val filteredMap = dogProvider.breedList.filter{it.key.breed=="labrador"}.values
//

//class test(breed:String){
//    val breed:String = breed
//    operator fun invoke():String{
//        return "raza:$breed"
//    }
//}
//
//fun main(){
//    print(test("asd"))
//}

//print(dogProvider.breedList)
//    for (it in dogProvider.breedList){
//        print(it.key.breed)
//    }

//}