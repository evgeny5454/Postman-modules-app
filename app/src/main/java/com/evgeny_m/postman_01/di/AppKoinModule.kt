package com.evgeny_m.postman_01.di

import com.evgeny_m.navigator_api.AppNavigator
import com.evgeny_m.navigator_impl.KoinAppNavigator
import org.koin.core.module.Module
import org.koin.dsl.module

object AppKoinModule {
    fun create(): Module {
        return module {
            single<AppNavigator> { KoinAppNavigator() }
        }
    }
}