package com.example.testdogs.domain.model

data class DogList(
    var dogs: MutableMap<String,List<String>>
) {
    operator fun set(breed: String, value: DogList) {
        dogs[breed] = value.dogs.getValue(breed)
    }

    operator fun get(breed: String): DogList {
        return DogList(mutableMapOf(breed to dogs.getValue(breed)))
    }


}

