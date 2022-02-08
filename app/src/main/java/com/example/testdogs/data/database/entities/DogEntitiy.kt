package com.example.testdogs.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "dogs_table")
data class DogEntitiy(
     @PrimaryKey(autoGenerate = true)
     var dogId: Long = 0L,
     @ColumnInfo(name = "breed")
     var breed: String = "",
     @ColumnInfo(name = "img")
     var img:String = ""
)