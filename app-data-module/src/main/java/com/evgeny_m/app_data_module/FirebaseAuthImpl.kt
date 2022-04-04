package com.evgeny_m.app_data_module

import android.app.Activity
import android.util.JsonToken
import android.util.Log
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import java.util.concurrent.TimeUnit

class FirebaseAuthImpl(private val activity: Activity) {
    private lateinit var callbacks: PhoneAuthProvider.OnVerificationStateChangedCallbacks
    private var auth: FirebaseAuth = FirebaseAuth.getInstance()
    private lateinit var verificationId: String

    fun auth() : Boolean  {
        val uid = auth.currentUser?.uid
        Log.d("FirebaseAuth", uid.toString())
        return uid != null
    }
    fun registerByPhone(phone: String) {
        callbacks = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks(){
            override fun onVerificationCompleted(p0: PhoneAuthCredential) {
                //TODO("Not yet implemented")
            }

            override fun onVerificationFailed(p0: FirebaseException) {
                //TODO("Not yet implemented")
            }

            override fun onCodeSent(id: String, token: PhoneAuthProvider.ForceResendingToken) {
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

    fun sendCode(code: String){
        val credential = PhoneAuthProvider.getCredential(verificationId, code)
        auth.signInWithCredential(credential)
    }
}

