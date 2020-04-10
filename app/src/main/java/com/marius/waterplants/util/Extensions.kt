package com.marius.waterplants.util

fun <T> T?.default(default: T): T {
    return this ?: default
}