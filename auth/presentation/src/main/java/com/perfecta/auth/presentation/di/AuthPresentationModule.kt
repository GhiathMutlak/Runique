package com.perfecta.auth.presentation.di

import com.perfecta.auth.presentation.login.LoginViewModel
import com.perfecta.auth.presentation.register.RegisterViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val authPresentationModule = module {
    viewModelOf(::RegisterViewModel)
    viewModelOf(::LoginViewModel)
}