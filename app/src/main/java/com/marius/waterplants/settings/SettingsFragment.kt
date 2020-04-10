package com.marius.waterplants.settings

import android.os.Bundle
import android.view.View

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager

import com.marius.waterplants.R
import com.marius.waterplants.ui.RoundedBottomSheetDialogFragment

import kotlinx.android.synthetic.main.fragment_settings.settings_recycler as settingsRecycler

class SettingsFragment : RoundedBottomSheetDialogFragment(R.layout.fragment_settings) {

    companion object {
        const val TAG = "SettingsFragment"
    }

    private lateinit var viewModel: SettingsViewModel
    private val adapter = SettingsAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        settingsRecycler.layoutManager = LinearLayoutManager(context)
        settingsRecycler.addItemDecoration(
            DividerItemDecoration(
                context,
                DividerItemDecoration.VERTICAL
            )
        )
        settingsRecycler.adapter = adapter

        viewModel = ViewModelProvider(this).get(SettingsViewModel::class.java)
        viewModel.getSettings().observe(viewLifecycleOwner, Observer { adapter.submitList(it) })
        viewModel.onViewsInitialized()
    }
}
