package com.example.feature_auth_domain

interface Repository {
    fun registerByPhone(phone: String)
    fun enterCode(code: String)
}