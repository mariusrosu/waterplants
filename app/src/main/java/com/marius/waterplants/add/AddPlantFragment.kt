package com.marius.waterplants.add

import android.os.Bundle
import android.view.KeyEvent
import android.view.View

import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.adapter.FragmentStateAdapter

import com.marius.waterplants.R
import com.marius.waterplants.add.pages.interval.WaterIntervalFragment
import com.marius.waterplants.add.pages.name.PlantNameFragment
import com.marius.waterplants.add.pages.type.PlantTypeFragment
import com.marius.waterplants.ui.RoundedBottomSheetDialogFragment

import kotlinx.android.synthetic.main.fragment_add_plant.view_pager as viewPager

class AddPlantFragment : RoundedBottomSheetDialogFragment(R.layout.fragment_add_plant) {

    companion object {
        const val TAG = "AddPlantFragment"
    }

    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory).get(AddPlantViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewPager.adapter = PlantPagesAdapter(this)
        viewPager.isUserInputEnabled = false

        viewModel.viewState().observe(viewLifecycleOwner, Observer { state ->
            when (state) {
                is AddPlantViewState.ChangePlantPage -> viewPager.currentItem = state.page
                is AddPlantViewState.PlantCreated -> dismiss()
            }
        })
    }

    override fun onResume() {
        super.onResume()
        dialog?.setOnKeyListener { _, keyCode, keyEvent ->
            if (KeyEvent.KEYCODE_BACK == keyCode && KeyEvent.ACTION_UP == keyEvent.action) {
                if (viewPager.currentItem > 0) {
                    viewPager.currentItem -= 1
                } else {
                    dismiss()
                }
                true
            } else {
                false
            }
        }
    }
}

private class PlantPagesAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount() = 3

    override fun createFragment(position: Int) = when (position) {
        0 -> PlantTypeFragment()
        1 -> WaterIntervalFragment()
        2 -> PlantNameFragment()
        else -> throw IllegalArgumentException("Plant detail fragment missing!")
    }
}
