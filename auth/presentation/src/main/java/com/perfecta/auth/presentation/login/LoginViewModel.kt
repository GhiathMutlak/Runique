@file:OptIn(ExperimentalFoundationApi::class)

package com.perfecta.auth.presentation.login


import android.R.attr.password
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.perfecta.auth.domain.AuthRepository
import com.perfecta.auth.domain.UserDataValidator
import com.perfecta.auth.presentation.R
import com.perfecta.core.domain.util.DataError
import com.perfecta.core.domain.util.Result
import com.perfecta.core.presentation.ui.UiText
import com.perfecta.core.presentation.ui.asUiText
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class LoginViewModel(
    private val authRepository: AuthRepository,
    private val validator: UserDataValidator
) : ViewModel() {

    var state by mutableStateOf(LoginState())
        private set

    private val eventChannel = Channel<LoginEvent>()
    val events = eventChannel.receiveAsFlow()

    init {
        val emailFlow = snapshotFlow { state.email.text }
        val passwordFlow = snapshotFlow { state.password.text }

        combine(emailFlow, passwordFlow) { email, password ->
            state = state.copy(
                canLogIn = validator.isValidEmail(email.toString().trim()) && password.isNotEmpty()
            )
        }.launchIn(viewModelScope)
    }

    fun onAction(action: LoginAction) {
        when (action) {
            LoginAction.OnLoginClick -> {
                login()
            }

            LoginAction.OnTogglePasswordVisibility -> {
                state = state.copy(
                    isPasswordVisible = !state.isPasswordVisible
                )
            }

            else -> {}
        }
    }

    private fun login() {
        viewModelScope.launch {
            state = state.copy(isLoggingIn = true)

            val result = authRepository.login(
                email = state.email.text.toString().trim(),
                password = state.password.text.toString()
            )

            state = state.copy(isLoggingIn = false)

            when (result) {
                is Result.Error -> {
                    if (result.error == DataError.Network.UNAUTHORIZED) {
                        eventChannel.send(
                            LoginEvent.Error(
                                UiText.StringResource(R.string.error_email_password_incorrect)
                            )
                        )
                    } else {
                        eventChannel.send(LoginEvent.Error(result.error.asUiText()))
                    }
                }

                is Result.Success -> {
                    eventChannel.send(LoginEvent.LoginSuccess)
                }
            }
        }
    }
}