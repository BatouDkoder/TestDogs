package com.example.testdogs.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.testdogs.data.database.dao.DogDao
import com.example.testdogs.data.database.entities.DogEntitiy

@Database(entities = [DogEntitiy::class], version = 1, exportSchema = false)
abstract class DogDatabase: RoomDatabase() {

    abstract fun getDogDao():DogDao
}