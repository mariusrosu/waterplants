package com.marius.waterplants.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.marius.waterplants.R
import com.marius.waterplants.dagger.ViewModelFactory

import dagger.android.support.AndroidSupportInjection

import javax.inject.Inject

abstract class RoundedBottomSheetDialogFragment(private val layoutId: Int) :
    BottomSheetDialogFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidSupportInjection.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(layoutId, container, false)
    }

    override fun getTheme(): Int =
        R.style.BottomSheet_Dialog_Theme

    override fun onCreateDialog(savedInstanceState: Bundle?): BottomSheetDialog =
        BottomSheetDialog(requireContext(), theme)
}