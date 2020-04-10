package com.marius.waterplants.add.pages.name

import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.TextView.OnEditorActionListener

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

import com.marius.waterplants.R
import com.marius.waterplants.add.AddPlantViewModel
import com.marius.waterplants.ui.BaseFragment

import kotlinx.android.synthetic.main.fragment_plant_name.plant_name_edit_text as plantNameEditText
import kotlinx.android.synthetic.main.fragment_plant_name.plant_name_finish_button as plantNameFinishButton
import kotlinx.android.synthetic.main.fragment_plant_name.selected_plant_type_image as selectedPlantTypeImage

class PlantNameFragment : BaseFragment(R.layout.fragment_plant_name) {
    private var viewModel: AddPlantViewModel? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = parentFragment?.let {
            ViewModelProvider(it, viewModelFactory).get(AddPlantViewModel::class.java)
        }
        viewModel?.let {
            it.selectedPlantType().observe(viewLifecycleOwner, Observer { plantType ->
                selectedPlantTypeImage.setImageResource(plantType.getIcon())
            })
        }

        plantNameFinishButton.setOnClickListener {
            createPlant(plantNameEditText.text.toString())
        }

        plantNameEditText.setOnEditorActionListener(OnEditorActionListener { input, action, _ ->
            if (action == EditorInfo.IME_ACTION_DONE) {
                createPlant(input.text.toString())
                return@OnEditorActionListener true
            }
            false
        })
    }

    private fun createPlant(name: String) {
        viewModel?.createPlant(name)
    }
}