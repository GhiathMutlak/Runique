package com.perfecta.auth.domain

interface PatternValidator {
    fun isEmailValid(email: String): Boolean
}