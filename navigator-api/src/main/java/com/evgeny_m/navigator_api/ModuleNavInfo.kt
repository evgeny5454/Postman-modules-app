package com.evgeny_m.navigator_api

interface ModuleNavInfo {

    fun getNavigationStartPointResId() : Int

    fun isFeatureAvailable() : Int
}