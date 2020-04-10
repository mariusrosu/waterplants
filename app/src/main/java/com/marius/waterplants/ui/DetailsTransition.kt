package com.marius.waterplants.ui

import android.annotation.TargetApi
import android.content.Context
import android.os.Build
import android.util.AttributeSet

import androidx.transition.ChangeBounds
import androidx.transition.ChangeImageTransform
import androidx.transition.ChangeTransform
import androidx.transition.TransitionSet

@TargetApi(Build.VERSION_CODES.LOLLIPOP)
class DetailsTransition : TransitionSet {
    constructor() {
        init()
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        init()
    }

    private fun init() {
        ordering = ORDERING_TOGETHER
        addTransition(ChangeBounds())
            .addTransition(ChangeTransform())
            .addTransition(ChangeImageTransform())
    }
}