package com.perfecta.auth.domain

interface PatternValidator {
    fun matches(value: String): Boolean
}