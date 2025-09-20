package com.perfecta.run.presentation.run_overview

import com.perfecta.run.presentation.run_overview.models.RunUi

data class RunOverviewState(
    val runs: List<RunUi> = emptyList()
)