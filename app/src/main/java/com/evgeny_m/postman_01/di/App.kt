package com.evgeny_m.postman_01.di

import android.app.Application
import com.evgeny_m.feature_contacts_presenter.api.FeatureContactsUIKoinModule
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
                )
            )
        }
    }
}