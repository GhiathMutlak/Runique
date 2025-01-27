package com.perfecta.run.presentation.di

import com.perfecta.run.presentation.active_run.ActiveRunViewModel
import com.perfecta.run.presentation.run_overview.RunOverviewViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val runPresentationModule = module {
    viewModelOf(::RunOverviewViewModel)
    viewModelOf(::ActiveRunViewModel)
}