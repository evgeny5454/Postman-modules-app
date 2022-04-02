package com.evgeny_m.feature_auth_presenter.api

import com.evgeny_m.feature_auth_api.FeatureAuthDestination
import com.evgeny_m.feature_auth_presenter.FeatureAuthNavDestination
import org.koin.core.module.Module
import org.koin.dsl.module

object FeatureAuthUIKoinModule {
    fun create(): Module {
        return module {
            factory<FeatureAuthDestination> { FeatureAuthNavDestination() }
        }
    }
}