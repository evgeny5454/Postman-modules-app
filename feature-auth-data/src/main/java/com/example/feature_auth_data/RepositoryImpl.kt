package com.example.feature_auth_data

import android.app.Activity
import com.example.feature_auth_domain.Repository
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import java.util.concurrent.TimeUnit

class RepositoryImpl(private val activity: Activity): Repository {

    private lateinit var callbacks: PhoneAuthProvider.OnVerificationStateChangedCallbacks
    private lateinit var userPhone : String
    private lateinit var verificationId: String
    private var auth: FirebaseAuth = FirebaseAuth.getInstance()

    override fun registerByPhone(phone: String) {
        callbacks = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            override fun onVerificationCompleted(credential: PhoneAuthCredential) {
                //userPhone = phone
            }

            override fun onVerificationFailed(exeptionMessage: FirebaseException) {

            }

            override fun onCodeSent(
                id: String,
                token: PhoneAuthProvider.ForceResendingToken
            ) {
                //userPhone = phone
                verificationId = id
            }
        }
        val option = PhoneAuthOptions.newBuilder()
            .setPhoneNumber(phone)
            .setTimeout(120L, TimeUnit.SECONDS)
            .setActivity(activity)
            .setCallbacks(callbacks)
            .build()
        PhoneAuthProvider.verifyPhoneNumber(option)
    }

    override fun enterCode(code: String) {
        val credential = PhoneAuthProvider.getCredential(verificationId, code)
        auth.signInWithCredential(credential)
    }
}