package site.aohan.compose_study_daily.innerapps.gmailclone.model

import androidx.compose.ui.graphics.vector.ImageVector

sealed class DrawerItemModel(
    val title: String,
) {
    object Divider : DrawerItemModel("")
    class Header(title: String) : DrawerItemModel(title)
    class Label(title: String, val icon: ImageVector) : DrawerItemModel(title)
}