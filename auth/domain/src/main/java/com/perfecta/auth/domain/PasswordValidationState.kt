package com.perfecta.auth.domain

data class PasswordValidationState(
    val hasMinLength: Boolean = false,
    val hasNumber: Boolean = false,
    val hasLowerCaseCharacter: Boolean = false,
    val hasUpperCaseCharacter: Boolean = false,
) {
    val isPasswordValid: Boolean
        get() = hasNumber && hasNumber && hasLowerCaseCharacter && hasUpperCaseCharacter
}