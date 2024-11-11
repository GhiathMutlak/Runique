package com.perfecta.auth.data

import android.util.Patterns
import com.perfecta.auth.domain.PatternValidator

object EmailPatternValidator : PatternValidator {
    override fun isEmailValid(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email.trim()).matches()
    }
}