package com.example.testdogs.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.testdogs.data.database.entities.DogEntitiy

@Dao
interface DogDao {
    @Query("Select * from dogs_table where breed LIKE :breed")
    suspend fun getAllDogsByBreed(breed: String): MutableList<DogEntitiy>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(dog:DogEntitiy)

}