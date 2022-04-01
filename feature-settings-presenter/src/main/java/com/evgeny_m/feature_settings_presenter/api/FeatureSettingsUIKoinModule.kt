package com.evgeny_m.feature_settings_presenter.api


import com.evgeny_m.feature_settings_api.FeatureSettingsDestination
import org.koin.core.module.Module
import org.koin.dsl.module

object FeatureSettingsUIKoinModule {
    fun create(): Module {
        return module {
            factory<FeatureSettingsDestination> {FeatureSettingsNavDestination()}
        }
    }
}