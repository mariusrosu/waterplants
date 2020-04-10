package com.marius.waterplants.garden

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.marius.waterplants.model.Plant
import com.marius.waterplants.model.PlantsRepository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

import javax.inject.Inject

class GardenViewModel @Inject constructor(private val repository: PlantsRepository) : ViewModel() {
    private val viewState = MutableLiveData<GardenViewState>()

    fun getViewState(): LiveData<GardenViewState> = viewState

    fun getPlants(): LiveData<List<Plant>> = repository.getAll()

}

sealed class GardenViewState {
    object ShowEmptyGarden : GardenViewState()
    data class ShowPlants(val plants: List<Plant>) : GardenViewState()
}
