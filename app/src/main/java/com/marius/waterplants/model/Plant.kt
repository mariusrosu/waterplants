package com.marius.waterplants.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.marius.waterplants.add.pages.type.PlantType

@Entity(tableName = "plants")
data class Plant(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val type: String
)