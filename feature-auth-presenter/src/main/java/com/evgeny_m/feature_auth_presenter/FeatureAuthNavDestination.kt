package com.evgeny_m.feature_auth_presenter

import com.evgeny_m.feature_auth_api.FeatureAuthDestination

class FeatureAuthNavDestination : FeatureAuthDestination {
    override fun getNavigationStartPointResId(): Int {
        return R.id.navigation_auth
    }

    override fun isFeatureAvailable(): Boolean {
        return true
    }
}