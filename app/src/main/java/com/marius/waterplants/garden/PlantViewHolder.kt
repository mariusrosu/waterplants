package com.marius.waterplants.garden

import android.view.View
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.RecyclerView

import com.marius.waterplants.add.pages.type.PlantType
import com.marius.waterplants.model.Plant

import kotlinx.android.synthetic.main.plant_item_view.view.plant_name_text_view as plantNameTextView
import kotlinx.android.synthetic.main.plant_item_view.view.plant_type_image_view as plantTypeImageView

class PlantViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(plant: Plant, type: PlantType?, onClick: (Int, View) -> Unit) = with(itemView) {
        plantNameTextView.text = plant.name
        type?.getIcon()?.let(plantTypeImageView::setImageResource)

        ViewCompat.setTransitionName(plantTypeImageView, "image_${plant.id}")

        itemView.setOnClickListener { onClick.invoke(plant.id, itemView) }
    }
}
