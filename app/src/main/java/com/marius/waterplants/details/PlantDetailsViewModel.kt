package com.marius.waterplants.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.marius.waterplants.model.Plant

import com.marius.waterplants.model.PlantsRepository

import javax.inject.Inject

class PlantDetailsViewModel @Inject constructor(private val repository: PlantsRepository) :
    ViewModel() {

    fun getPlant(id: Int): LiveData<Plant> = repository.get(id)
}
