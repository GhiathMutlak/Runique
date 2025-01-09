package com.perfecta.auth.domain

class UserDataValidator(
    val emailValidator: PatternValidator,
) {
    fun isValidEmail(email: String): Boolean {
        return emailValidator.matches(email)
    }

    fun isValidPassword(password: String): PasswordValidationState {
        val hasMinLength = password.length >= MIN_PASSWORD_LENGTH
        val isDigit = password.any { it.isDigit() }
        val isLowerCase = password.any { it.isLowerCase() }
        val isUpperCase = password.any { it.isUpperCase() }

        return PasswordValidationState(
            hasMinLength = hasMinLength,
            hasNumber = isDigit,
            hasLowerCaseCharacter = isLowerCase,
            hasUpperCaseCharacter = isUpperCase
        )
    }

    companion object {
        const val MIN_PASSWORD_LENGTH = 9
    }
}