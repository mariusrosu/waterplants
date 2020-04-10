package com.marius.waterplants.util

import android.content.Context

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ResourceHelper @Inject constructor(private val context: Context) {

    fun getText(resourceId: Int) = context.resources.getText(resourceId)
}