package com.marius.waterplants.details

import android.os.Build
import android.os.Bundle
import android.view.View

import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.transition.Fade

import com.marius.waterplants.R
import com.marius.waterplants.add.pages.type.PlantType
import com.marius.waterplants.ui.BaseFragment
import com.marius.waterplants.ui.DetailsTransition

import javax.inject.Inject

import kotlinx.android.synthetic.main.fragment_plant_details.plant_details_name_text_view as plantNameTextView
import kotlinx.android.synthetic.main.fragment_plant_details.plant_details_type_image_view as plantTypeImageView

class PlantDetailsFragment : BaseFragment(R.layout.fragment_plant_details) {

    companion object {
        private const val ARG_PLANT_ID = "arg_plant_id"

        fun newInstance(id: Int): PlantDetailsFragment {
            val fragment = PlantDetailsFragment()
            fragment.arguments = bundleOf(ARG_PLANT_ID to id)

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                fragment.sharedElementEnterTransition = DetailsTransition()
                fragment.sharedElementReturnTransition = DetailsTransition()
                fragment.enterTransition = Fade()
            }
            return fragment
        }
    }

    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory).get(PlantDetailsViewModel::class.java)
    }

    @Inject
    lateinit var plantTypes: Map<String, @JvmSuppressWildcards PlantType>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val id = arguments?.getInt(ARG_PLANT_ID)
        id?.let {
            viewModel.getPlant(id).observe(viewLifecycleOwner, Observer { plant ->
                plantNameTextView.text = plant.name
                plantTypes[plant.type]?.getIcon()?.let(plantTypeImageView::setImageResource)
            })
        }
    }
}
