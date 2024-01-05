package site.aohan.compose_study_daily.innerapps.newsapp.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Category
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Source
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarItemModel(val route: String, val icon: ImageVector, val label: String) {
    data object Home : BottomBarItemModel("News", Icons.Default.Home, "News")
    data object Categories : BottomBarItemModel("Categories", Icons.Default.Category, "Categories")
    data object Sources : BottomBarItemModel("Sources", Icons.Default.Source, "Sources")
}