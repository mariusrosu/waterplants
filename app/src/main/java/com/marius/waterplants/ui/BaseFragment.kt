package com.marius.waterplants.ui

import android.os.Bundle
import androidx.fragment.app.Fragment

import com.marius.waterplants.dagger.ViewModelFactory

import dagger.android.support.AndroidSupportInjection

import javax.inject.Inject

abstract class BaseFragment(layoutId: Int) : Fragment(layoutId) {
    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidSupportInjection.inject(this)
    }
}
