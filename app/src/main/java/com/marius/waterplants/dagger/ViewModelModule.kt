package com.marius.waterplants.dagger

import androidx.lifecycle.ViewModel

import com.marius.waterplants.add.AddPlantViewModel
import com.marius.waterplants.details.PlantDetailsViewModel
import com.marius.waterplants.garden.GardenViewModel
import com.marius.waterplants.settings.SettingsViewModel

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
internal abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(GardenViewModel::class)
    abstract fun bindGardenViewModel(viewModel: GardenViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(PlantDetailsViewModel::class)
    abstract fun bindPlantDetailsViewModel(viewModel: PlantDetailsViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(AddPlantViewModel::class)
    abstract fun bindAddPlantViewModel(viewModel: AddPlantViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SettingsViewModel::class)
    abstract fun bindSettingsViewModel(viewModel: SettingsViewModel): ViewModel
}