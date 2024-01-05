package site.aohan.compose_study_daily.innerapps.newsapp.component

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import site.aohan.compose_study_daily.innerapps.newsapp.model.BottomBarItemModel
import site.aohan.compose_study_daily.innerapps.newsapp.screens.HomeScreen

@SuppressLint("RestrictedApi")
@Composable
fun BottomMenuBar(navController: NavHostController) {

    val bottomBarList = getBottomBarItemList()
    val stackEntry by navController.currentBackStackEntryAsState()
    NavigationBar {
        bottomBarList.forEach {barItem->
            NavigationBarItem(
                selected = barItem.route == stackEntry?.destination?.route,
                label = { Text(text = barItem.label) },
                onClick = {
                    navController.navigate(barItem.route) {
                        // 保存最开始的页面(home)
                        navController.graph.startDestinationRoute?.let {
                            popUpTo(it) {
                                // 保存状态
                                saveState = true
                                // 代表当前页面也回退掉
                                // inclusive = true
                            }
                        }
                        // 单例页面启动
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = { Icon(imageVector = barItem.icon, contentDescription = barItem.label) },
                alwaysShowLabel = true
            )
        }
    }
}

private fun getBottomBarItemList() = listOf(
    BottomBarItemModel.Home, BottomBarItemModel.Categories, BottomBarItemModel.Sources
)

fun NavGraphBuilder.newsAppBottomBar(padding: PaddingValues, navController: NavHostController) {
    composable(BottomBarItemModel.Home.route) {
        HomeScreen(
            modifier = Modifier.padding(padding), navController = navController
        )
    }

    composable(BottomBarItemModel.Categories.route) {

    }

    composable(BottomBarItemModel.Sources.route) {

    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewBottomMenuBar() {
    BottomMenuBar(rememberNavController())
}