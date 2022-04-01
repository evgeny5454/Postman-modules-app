package com.evgeny_m.feature_single_chat_presenter.api


import com.evgeny_m.feature_single_chat_api.FeatureSingleChatDestination
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

object FeatureSingleChatUIKoinModule {
    fun create(): Module {
        return module {

            factory<FeatureSingleChatDestination> {FeatureSingleChatNavDestination()}
        }
    }
}