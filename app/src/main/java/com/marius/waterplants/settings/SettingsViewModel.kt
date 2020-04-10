package com.marius.waterplants.settings

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class SettingsViewModel @Inject constructor() : ViewModel() {
    private val settingsLiveData = MutableLiveData<List<Setting>>()

    fun getSettings(): LiveData<List<Setting>> = settingsLiveData

    fun onViewsInitialized() {
        val settings =
            mutableListOf(Setting("Sort By", "Name"), Setting("Theme", "System default"))
        settingsLiveData.value = settings
    }
}
