package com.marius.waterplants.garden

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

import com.marius.waterplants.R
import com.marius.waterplants.add.pages.type.PlantType
import com.marius.waterplants.model.Plant

class PlantsAdapter(
    private val plantTypes: Map<String, PlantType>,
    private val onClick: (Int, View) -> Unit
) : ListAdapter<Plant, PlantViewHolder>(PlantDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlantViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.plant_item_view, parent, false)
        return PlantViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PlantViewHolder, position: Int) {
        val plant = getItem(position)
        val type = plantTypes[plant.type]
        holder.bind(plant, type, onClick)
    }
}

private class PlantDiffCallback : DiffUtil.ItemCallback<Plant>() {

    override fun areItemsTheSame(old: Plant, new: Plant) = old.id == new.id

    override fun areContentsTheSame(old: Plant, new: Plant) = old == new
}

fun <T : RecyclerView.ViewHolder> T.setOnClickListener(onClick: (position: Int) -> Unit): T {
    itemView.setOnClickListener {
        onClick.invoke(adapterPosition)
    }
    return this
}
