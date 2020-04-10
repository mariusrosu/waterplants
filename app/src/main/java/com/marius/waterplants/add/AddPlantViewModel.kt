package com.marius.waterplants.add

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.marius.waterplants.add.pages.type.IndoorPlantType
import com.marius.waterplants.add.pages.type.PlantType

import com.marius.waterplants.model.Plant
import com.marius.waterplants.model.PlantsRepository
import com.marius.waterplants.util.default
import kotlinx.coroutines.launch
import javax.inject.Inject

class AddPlantViewModel @Inject constructor(private val repository: PlantsRepository) :
    ViewModel() {

    private val selectedPlantType = MutableLiveData<PlantType>()
    private val selectedWaterInterval = MutableLiveData<Int>()
    private val viewState = MutableLiveData<AddPlantViewState>()

    fun selectedPlantType(): LiveData<PlantType> = selectedPlantType

    fun viewState(): LiveData<AddPlantViewState> = viewState

    fun setPlantType(type: PlantType?) {
        selectedPlantType.value = type
        viewState.value = AddPlantViewState.ChangePlantPage(1)
    }

    fun setWaterInterval(interval: Int) {
        selectedWaterInterval.value = interval
        viewState.value = AddPlantViewState.ChangePlantPage(2)
    }

    fun createPlant(name: String) {
        val type = selectedPlantType.value?.getType().default(IndoorPlantType.TYPE)
        val interval: Int = selectedWaterInterval.value.default(0)

        viewModelScope.launch {
            repository.insert(Plant(name = name, type = type))
            viewState.value = AddPlantViewState.PlantCreated
        }
    }
}

sealed class AddPlantViewState {
    data class ChangePlantPage(val page: Int) : AddPlantViewState()
    object PlantCreated : AddPlantViewState()
}
