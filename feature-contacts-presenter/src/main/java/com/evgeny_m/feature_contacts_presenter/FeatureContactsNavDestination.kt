package com.evgeny_m.feature_contacts_presenter

import com.evgeny_m.feature_contacts_api.FeatureContactsDestination

class FeatureContactsNavDestination : FeatureContactsDestination {
    override fun getNavigationStartPointResId(): Int {
        return R.id.navigation_contacts
    }

    override fun isFeatureAvailable(): Boolean {
        return true
    }
}