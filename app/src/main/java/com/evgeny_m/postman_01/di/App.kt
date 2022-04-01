package com.evgeny_m.postman_01.di

import android.app.Application
import com.evgeny_m.feature_auth_presenter.api.FeatureAuthUIKoinModule
import com.evgeny_m.feature_contacts_presenter.api.FeatureContactsUIKoinModule
import com.evgeny_m.feature_settings_presenter.api.FeatureSettingsUIKoinModule
import com.evgeny_m.feature_single_chat_presenter.api.FeatureSingleChatUIKoinModule
import org.koin.core.context.startKoin

@Suppress("unused")
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(
                listOf(
                    AppKoinModule.create(),
                    FeatureContactsUIKoinModule.create(),
                    FeatureSettingsUIKoinModule.create(),
                    FeatureSingleChatUIKoinModule.create(),
                    FeatureAuthUIKoinModule.create()
                )
            )
        }
    }
}