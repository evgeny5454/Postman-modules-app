package com.evgeny_m.feature_contacts_presenter.api

import com.evgeny_m.feature_contacts_api.FeatureContactsDestination
import com.evgeny_m.feature_contacts_presenter.FeatureContactsNavDestination
import org.koin.core.module.Module
import org.koin.dsl.module

object FeatureContactsUIKoinModule {
    fun create(): Module {
        return module {
            factory<FeatureContactsDestination> { FeatureContactsNavDestination() }
        }
    }
}