package site.aohan.compose_study_daily.model

import androidx.compose.runtime.Composable
import androidx.navigation.NavOptionsBuilder

data class NavigationItem(
    val tag: String,
    var visibleTitle: String = tag,
    var navOptionBuilder: NavOptionsBuilder.() -> Unit = {},
    val composable: @Composable (() -> Unit)
)
