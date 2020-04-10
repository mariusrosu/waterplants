package com.marius.waterplants.add.pages.interval

import android.os.Bundle
import android.view.View

import androidx.lifecycle.ViewModelProvider

import com.marius.waterplants.R
import com.marius.waterplants.add.AddPlantViewModel
import com.marius.waterplants.ui.BaseFragment

import kotlinx.android.synthetic.main.fragment_water_interval.water_interval_text_view as intervalTextView
import kotlinx.android.synthetic.main.fragment_water_interval.water_interval_continue_button as continueButton
import kotlinx.android.synthetic.main.fragment_water_interval.water_interval_slider as intervalSlider

class WaterIntervalFragment : BaseFragment(R.layout.fragment_water_interval) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel = parentFragment?.let {
            ViewModelProvider(it, viewModelFactory).get(AddPlantViewModel::class.java)
        }

        intervalSlider.addOnChangeListener { _, value, _ ->
            intervalTextView.text = resources.getQuantityText(R.plurals.days, value.toInt())
        }

        continueButton.setOnClickListener {
            viewModel?.setWaterInterval(intervalSlider.value.toInt())
        }
    }
}
