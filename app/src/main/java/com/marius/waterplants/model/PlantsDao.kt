package com.marius.waterplants.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PlantsDao {

    @Query("SELECT * from plants")
    fun getAll(): LiveData<List<Plant>>

    @Query("SELECT * from plants where id = :id LIMIT 1")
    fun get(id: Int): LiveData<Plant>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(plant: Plant)
}