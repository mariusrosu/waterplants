package com.marius.waterplants.model

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Plant::class], version = 3, exportSchema = false)
abstract class PlantsDatabase : RoomDatabase() {

    abstract fun plantsDao(): PlantsDao
}