package com.perfecta.auth.presentation.login

import com.perfecta.core.presentation.ui.UiText

sealed interface LoginEvent {
    data class Error(val error: UiText) : LoginEvent
    data object LoginSuccess : LoginEvent
}