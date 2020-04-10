package com.marius.waterplants.add.pages.type

import com.marius.waterplants.R

interface PlantType {

    fun getType(): String

    fun getName(): Int

    fun getIcon(): Int
}

class IndoorPlantType : PlantType {

    companion object {
        const val TYPE = "indoor_plant"
    }

    override fun getType() = TYPE

    override fun getName() = R.string.plant_type_indoor_plant

    override fun getIcon() = R.drawable.ic_indoor_plant
}

class OutdoorPlantType : PlantType {

    companion object {
        const val TYPE = "outdoor_plant"
    }

    override fun getType() = TYPE

    override fun getName() = R.string.plant_type_outdoor_plant

    override fun getIcon() = R.drawable.ic_outdoor_plant
}

class IndoorFlowerType : PlantType {

    companion object {
        const val TYPE = "indoor_flower"
    }

    override fun getType() = TYPE

    override fun getName() = R.string.plant_type_indoor_flower

    override fun getIcon() = R.drawable.ic_indoor_flower
}

class OutdoorFlowerType : PlantType {

    companion object {
        const val TYPE = "outdoor_flower"
    }

    override fun getType() = TYPE

    override fun getName() = R.string.plant_type_outdoor_flower

    override fun getIcon() = R.drawable.ic_outdoor_flower
}

class CactusType : PlantType {

    companion object {
        const val TYPE = "cactus"
    }

    override fun getType() = TYPE

    override fun getName() = R.string.plant_type_cactus

    override fun getIcon() = R.drawable.ic_cactus
}

class SeedsType : PlantType {

    companion object {
        const val TYPE = "seeds"
    }

    override fun getType() = TYPE

    override fun getName() = R.string.plant_type_seeds

    override fun getIcon() = R.drawable.ic_seeds
}

class TreeType : PlantType {

    companion object {
        const val TYPE = "tree"
    }

    override fun getType() = TYPE

    override fun getName() = R.string.plant_type_tree

    override fun getIcon() = R.drawable.ic_tree
}

class FruitType : PlantType {

    companion object {
        const val TYPE = "fruit"
    }

    override fun getType() = TYPE

    override fun getName() = R.string.plant_type_fruit

    override fun getIcon() = R.drawable.ic_fruit
}

class VegetableType : PlantType {

    companion object {
        const val TYPE = "vegetable"
    }

    override fun getType() = TYPE

    override fun getName() = R.string.plant_type_vegetable

    override fun getIcon() = R.drawable.ic_vegetable
}
