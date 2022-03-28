package com.evgeny_m.postman_01.di

import android.app.Application
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(
                listOf(
                    AppKoinModule.create()
                )
            )
        }
    }
}