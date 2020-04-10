package com.marius.waterplants.drawer

import android.os.Bundle
import android.view.View

import com.marius.waterplants.R
import com.marius.waterplants.ui.RoundedBottomSheetDialogFragment

import kotlinx.android.synthetic.main.fragment_bottom_drawer.about as aboutItem
import kotlinx.android.synthetic.main.fragment_bottom_drawer.add_new_plant as addNewPlantItem
import kotlinx.android.synthetic.main.fragment_bottom_drawer.open_source_licences as openSourceItem

class BottomDrawerFragment : RoundedBottomSheetDialogFragment(R.layout.fragment_bottom_drawer) {

    companion object {
        const val TAG = "BottomDrawerFragment"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        addNewPlantItem.setOnClickListener { }

        aboutItem.setOnClickListener { }

        openSourceItem.setOnClickListener { }
    }
}