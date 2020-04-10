package com.marius.waterplants.add.pages.type

import android.os.Bundle
import android.view.View

import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager

import com.marius.waterplants.R
import com.marius.waterplants.add.AddPlantViewModel
import com.marius.waterplants.ui.BaseFragment

import javax.inject.Inject

import kotlinx.android.synthetic.main.fragment_plant_type.type_recycler as typeRecyclerView

class PlantTypeFragment : BaseFragment(R.layout.fragment_plant_type) {

    companion object {
        private const val GRID_COLUMN_COUNT = 3
    }

    @Inject
    lateinit var plantTypes: Map<String, @JvmSuppressWildcards PlantType>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = PlantTypeAdapter(plantTypes.values.toList())
        typeRecyclerView.adapter = adapter
        typeRecyclerView.layoutManager = object : GridLayoutManager(context, GRID_COLUMN_COUNT) {
            override fun canScrollVertically() = false
        }

        val viewModel = parentFragment?.let {
            ViewModelProvider(it, viewModelFactory).get(AddPlantViewModel::class.java)
        }
        adapter.setOnItemClickListener { type -> viewModel?.setPlantType(plantTypes[type]) }
    }
}
