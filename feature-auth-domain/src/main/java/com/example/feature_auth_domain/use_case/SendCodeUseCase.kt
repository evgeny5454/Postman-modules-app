package com.example.feature_auth_domain.use_case

import com.example.feature_auth_domain.Repository

class SendCodeUseCase(private val repository: Repository) {

    fun execute(code: String) {
        repository.enterCode(code)
    }
}