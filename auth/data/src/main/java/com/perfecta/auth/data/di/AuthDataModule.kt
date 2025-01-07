package com.perfecta.auth.data.di

import com.perfecta.auth.data.AuthRepositoryImpl
import com.perfecta.auth.data.EmailPatternValidator
import com.perfecta.auth.domain.AuthRepository
import com.perfecta.auth.domain.PatternValidator
import com.perfecta.auth.domain.UserDataValidator
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val authDataModule = module {
    single<PatternValidator> {
        EmailPatternValidator
    }

    singleOf(::UserDataValidator)
    singleOf(::AuthRepositoryImpl).bind<AuthRepository>()
}