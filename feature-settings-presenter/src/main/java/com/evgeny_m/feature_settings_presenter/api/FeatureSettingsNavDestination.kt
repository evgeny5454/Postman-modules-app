package com.evgeny_m.feature_settings_presenter.api

import com.evgeny_m.feature_settings_api.FeatureSettingsDestination
import com.evgeny_m.feature_settings_presenter.R


class FeatureSettingsNavDestination : FeatureSettingsDestination {
    override fun getNavigationStartPointResId(): Int {
        return R.id.navigation_settings
    }

    override fun isFeatureAvailable(): Boolean {
        return true
    }
}