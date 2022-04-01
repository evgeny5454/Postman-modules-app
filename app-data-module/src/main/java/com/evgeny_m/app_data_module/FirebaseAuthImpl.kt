package com.evgeny_m.app_data_module

import com.google.firebase.auth.FirebaseAuth

class FirebaseAuthImpl {

    private var auth: FirebaseAuth = FirebaseAuth.getInstance()

    fun auth() : Boolean  {
        val uid = auth.currentUser?.uid
        return uid != null
    }
}

