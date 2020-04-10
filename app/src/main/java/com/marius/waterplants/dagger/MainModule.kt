package com.marius.waterplants.dagger

import com.marius.waterplants.add.pages.type.*
import dagger.Module
import dagger.Provides

@Module
class MainModule {

    @Provides
    fun providePlantTypes() = mapOf(
        IndoorPlantType.TYPE to IndoorPlantType(),
        OutdoorPlantType.TYPE to OutdoorPlantType(),
        IndoorFlowerType.TYPE to IndoorFlowerType(),
        OutdoorFlowerType.TYPE to OutdoorFlowerType(),
        CactusType.TYPE to CactusType(),
        SeedsType.TYPE to SeedsType(),
        TreeType.TYPE to TreeType(),
        FruitType.TYPE to FruitType(),
        VegetableType.TYPE to VegetableType()
    )
}