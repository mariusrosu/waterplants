package com.marius.waterplants.model

import androidx.lifecycle.LiveData

import javax.inject.Inject

class PlantsRepository @Inject constructor(private val plantsDao: PlantsDao) {

    fun getAll(): LiveData<List<Plant>> = plantsDao.getAll()

    fun get(id: Int): LiveData<Plant> = plantsDao.get(id)

    suspend fun insert(plant: Plant) {
        plantsDao.insert(plant)
    }
}
