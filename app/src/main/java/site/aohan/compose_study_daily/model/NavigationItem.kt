package site.aohan.compose_study_daily.model

import androidx.compose.runtime.Composable

data class NavigationItem(
    val tag: String,
    var visibleTitle: String = tag,
    val composable: @Composable (() -> Unit)
)
