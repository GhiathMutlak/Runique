package com.perfecta.core.data.di

import com.perfecta.core.data.auth.EncryptedSessionStorage
import com.perfecta.core.data.networking.HttpClientFactory
import com.perfecta.core.domain.util.SessionStorage
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val coreDataModule = module {
    single {
        HttpClientFactory(get()).build()
    }

    singleOf(::EncryptedSessionStorage).bind<SessionStorage>()
}