package com.perfecta.run.presentation.run_overview

import com.perfecta.run.presentation.run_overview.models.RunUi

sealed interface RunOverviewAction {
    data object OnStartClick : RunOverviewAction
    data object OnLogoutClick : RunOverviewAction
    data object OnAnalyticsClick : RunOverviewAction
    data class DeleteRun(val runUi: RunUi): RunOverviewAction
}