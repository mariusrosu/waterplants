package com.marius.waterplants.add.pages.type

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView

import com.marius.waterplants.R
import com.marius.waterplants.garden.setOnClickListener

import kotlinx.android.synthetic.main.plant_type_item_view.view.plant_type_image as plantTypeImage
import kotlinx.android.synthetic.main.plant_type_item_view.view.plant_type_text as plantTypeText

class PlantTypeAdapter(private val types: List<PlantType>) :
    RecyclerView.Adapter<PlantTypeViewHolder>() {
    private lateinit var onClick: (plantType: String) -> Unit

    fun setOnItemClickListener(onClick: (plantType: String) -> Unit) {
        this.onClick = onClick
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlantTypeViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.plant_type_item_view, parent, false)
        return PlantTypeViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PlantTypeViewHolder, position: Int) {
        val plantType = types[position]
        holder.bind(plantType)
        holder.setOnClickListener { onClick.invoke(plantType.getType()) }
    }

    override fun getItemCount() = types.size
}

class PlantTypeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(type: PlantType) = with(itemView) {
        val resources = itemView.context.resources
        plantTypeText.text = resources.getText(type.getName())
        plantTypeImage.setImageResource(type.getIcon())
    }
}
