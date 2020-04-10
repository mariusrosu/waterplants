package com.marius.waterplants.dagger

import com.marius.waterplants.add.AddPlantFragment
import com.marius.waterplants.add.pages.interval.WaterIntervalFragment
import com.marius.waterplants.add.pages.name.PlantNameFragment
import com.marius.waterplants.add.pages.type.PlantTypeFragment
import com.marius.waterplants.details.PlantDetailsFragment
import com.marius.waterplants.drawer.BottomDrawerFragment
import com.marius.waterplants.garden.GardenFragment
import com.marius.waterplants.settings.SettingsFragment

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {

    @ContributesAndroidInjector
    internal abstract fun contributeGardenFragment(): GardenFragment

    @ContributesAndroidInjector
    internal abstract fun contributePlantDetailsFragment(): PlantDetailsFragment

    @ContributesAndroidInjector
    internal abstract fun contributeAddPlantFragment(): AddPlantFragment

    @ContributesAndroidInjector
    internal abstract fun contributePlantTypeFragment(): PlantTypeFragment

    @ContributesAndroidInjector
    internal abstract fun contributePlantNameFragment(): PlantNameFragment

    @ContributesAndroidInjector
    internal abstract fun contributeWaterIntervalFragment(): WaterIntervalFragment

    @ContributesAndroidInjector
    internal abstract fun contributeSettingsFragment(): SettingsFragment

    @ContributesAndroidInjector
    internal abstract fun contributeBottomDrawerFragment(): BottomDrawerFragment
}