package com.marius.waterplants.model

import android.content.Context
import androidx.room.Room

import dagger.Module
import dagger.Provides

import javax.inject.Singleton

@Module
class RoomModule {

    @Singleton
    @Provides
    fun providePlantsDatabase(context: Context) =
        Room.databaseBuilder(context, PlantsDatabase::class.java, "plants.db").fallbackToDestructiveMigration().build()

    @Singleton
    @Provides
    fun providePlantsDao(plantsDatabase: PlantsDatabase) = plantsDatabase.plantsDao()

    @Singleton
    @Provides
    fun providePlantsRepository(plantsDao: PlantsDao) = PlantsRepository(plantsDao)
}
