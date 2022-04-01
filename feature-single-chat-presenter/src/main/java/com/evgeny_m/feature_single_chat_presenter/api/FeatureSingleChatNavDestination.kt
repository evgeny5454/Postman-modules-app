package com.evgeny_m.feature_single_chat_presenter.api

import com.evgeny_m.feature_single_chat_api.FeatureSingleChatDestination
import com.evgeny_m.feature_single_chat_presenter.R


class FeatureSingleChatNavDestination : FeatureSingleChatDestination {
    override fun getNavigationStartPointResId(): Int {
        return R.id.navigation_single_chat
    }

    override fun isFeatureAvailable(): Boolean {
        return true
    }
}