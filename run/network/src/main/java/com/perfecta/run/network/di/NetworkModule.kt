package com.perfecta.run.network.di

import com.perfecta.core.domain.run.RemoteRunDataSource
import com.perfecta.run.network.KtorRemoteRunDataSource
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module


val networkModule = module {
    singleOf(::KtorRemoteRunDataSource).bind<RemoteRunDataSource>()
}