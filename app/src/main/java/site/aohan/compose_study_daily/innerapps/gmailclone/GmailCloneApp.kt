package site.aohan.compose_study_daily.innerapps.gmailclone

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material.icons.filled.AllInbox
import androidx.compose.material.icons.filled.LocalOffer
import androidx.compose.material.icons.filled.PeopleAlt
import androidx.compose.material.icons.filled.StarBorder
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import site.aohan.compose_study_daily.innerapps.gmailclone.config.Routes
import site.aohan.compose_study_daily.innerapps.gmailclone.model.DrawerItemModel
import site.aohan.compose_study_daily.innerapps.gmailclone.screens.HomeScreen

@Composable
fun GmailCloneApp() {
    val coroutineScope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val navController = rememberNavController()
    val drawerItemList = getDrawerItems()
    val scrollState = rememberScrollState()
    ModalNavigationDrawer(
        drawerContent = {
            ModalDrawerSheet(modifier = Modifier.verticalScroll(scrollState)) {
                Text(
                    text = "Gmail",
                    modifier = Modifier.padding(start = 20.dp, top = 20.dp),
                    color = Color.Red,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
                drawerItemList.forEach { item ->
                    when (item) {
                        DrawerItemModel.Divider -> Divider()
                        is DrawerItemModel.Header -> Text(text = item.title)
                        is DrawerItemModel.Label -> NavigationDrawerItem(
                            label = { Text(text = item.title) },
                            selected = false,
                            onClick = { /*TODO*/ },
                            icon = { Icon(imageVector = item.icon, contentDescription = null) }
                        )
                    }
                }
            }
        },
        drawerState = drawerState
    ) {
        NavHost(navController = navController, startDestination = Routes.Home) {
            composable(Routes.Home) {
                HomeScreen(drawerState = drawerState, coroutineScope = coroutineScope)
            }
        }

    }
}

private fun getDrawerItems() = listOf(
    DrawerItemModel.Divider,
    DrawerItemModel.Label("主要", Icons.Filled.AllInbox),
    DrawerItemModel.Label("推广", Icons.Filled.LocalOffer),
    DrawerItemModel.Label("社交", Icons.Filled.PeopleAlt),
    DrawerItemModel.Header("所有标签"),
    DrawerItemModel.Label("已加星标", Icons.Filled.StarBorder),
    DrawerItemModel.Label("已加星标", Icons.Filled.StarBorder),
    DrawerItemModel.Label("已加星标", Icons.Filled.StarBorder),
    DrawerItemModel.Label("已加星标", Icons.Filled.StarBorder),
    DrawerItemModel.Label("已加星标", Icons.Filled.StarBorder),
    DrawerItemModel.Label("已加星标", Icons.Filled.StarBorder),
    DrawerItemModel.Label("已加星标", Icons.Filled.StarBorder),
    DrawerItemModel.Label("已加星标", Icons.Filled.StarBorder),
    DrawerItemModel.Label("已加星标", Icons.Filled.StarBorder),
    DrawerItemModel.Label("已加星标", Icons.Filled.StarBorder),
    DrawerItemModel.Label("已加星标", Icons.Filled.StarBorder),
    DrawerItemModel.Label("已加星标", Icons.Filled.StarBorder),
    DrawerItemModel.Label("已加星标", Icons.Filled.StarBorder),
    DrawerItemModel.Label("已加星标", Icons.Filled.StarBorder),
    DrawerItemModel.Label("已加星标", Icons.Filled.StarBorder),
    DrawerItemModel.Label("已加星标", Icons.Filled.StarBorder),
    DrawerItemModel.Label("已加星标", Icons.Filled.StarBorder),
    DrawerItemModel.Label("已延后", Icons.Filled.AccessTime)
)

@Preview
@Composable
fun PreviewGmailScreen() {
    GmailCloneApp()
}