package com.marius.waterplants.garden

import android.os.Bundle
import android.view.View

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.transition.Fade

import com.marius.waterplants.R
import com.marius.waterplants.add.pages.type.PlantType
import com.marius.waterplants.details.PlantDetailsFragment
import com.marius.waterplants.model.Plant
import com.marius.waterplants.ui.BaseFragment

import timber.log.Timber

import javax.inject.Inject

import kotlinx.android.synthetic.main.fragment_garden.garden_empty_view as gardenEmptyView
import kotlinx.android.synthetic.main.fragment_garden.plants_recycler_view as plantsRecyclerView
import kotlinx.android.synthetic.main.plant_item_view.view.plant_name_text_view as plantNameTextView
import kotlinx.android.synthetic.main.plant_item_view.view.plant_type_image_view as plantTypeImageView

class GardenFragment : BaseFragment(R.layout.fragment_garden) {

    companion object {
        fun newInstance() = GardenFragment()
    }

    @Inject
    lateinit var plantTypes: Map<String, @JvmSuppressWildcards PlantType>

    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory).get(GardenViewModel::class.java)
    }

    private val adapter by lazy {
        PlantsAdapter(plantTypes, this::showPlantDetails)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        plantsRecyclerView.layoutManager = LinearLayoutManager(context)
        plantsRecyclerView.adapter = adapter

        viewModel.getPlants().observe(viewLifecycleOwner, Observer {
            Timber.d("Garden updated: $it")
            if (it.isEmpty()) {
                showEmptyGarden()
            } else {
                showPlants(it)
            }
        })
    }

    private fun showEmptyGarden() {
        plantsRecyclerView.visibility = View.GONE
        gardenEmptyView.visibility = View.VISIBLE
    }

    private fun showPlants(plants: List<Plant>) {
        plantsRecyclerView.visibility = View.VISIBLE
        gardenEmptyView.visibility = View.GONE
        adapter.submitList(plants)
    }

    private fun showPlantDetails(plantId: Int, view: View) {
        activity?.let {
            val fragment = PlantDetailsFragment.newInstance(plantId)
            exitTransition = Fade()

            it.supportFragmentManager
                .beginTransaction()
                .addSharedElement(
                    view.plantTypeImageView,
                    getString(R.string.transition_name_plant_type)
                )
                .replace(R.id.container_view, fragment)
                .addToBackStack(null)
                .commit()
        }
    }
}
