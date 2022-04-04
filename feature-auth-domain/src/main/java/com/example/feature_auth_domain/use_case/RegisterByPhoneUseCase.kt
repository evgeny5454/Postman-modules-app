package com.example.feature_auth_domain.use_case

import com.example.feature_auth_domain.Repository

class RegisterByPhoneUseCase(private val repository: Repository) {

    fun execute(phone: String) {
        repository.registerByPhone(phone)
    }
}