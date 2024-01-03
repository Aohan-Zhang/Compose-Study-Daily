package site.aohan.compose_study_daily.innerapps.newsapp

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import site.aohan.compose_study_daily.NavEnum
import site.aohan.compose_study_daily.component.WebViewContainer
import site.aohan.compose_study_daily.innerapps.newsapp.config.Route
import site.aohan.compose_study_daily.innerapps.newsapp.screens.HomeScreen

@Composable
fun NewsApp() {
    Scaffold { padding ->
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = Route.NewsAppHome) {
            composable(Route.NewsAppHome) {
                HomeScreen(modifier = Modifier.padding(padding), navController = navController)
            }

            composable(Route.NewsAppDetail) {

            }

            composable(NavEnum.WEB_VIEW.toString(), arguments = listOf(
                navArgument("url") {
                    type = NavType.StringType
                    require(true)
                }
            )) {
                WebViewContainer(url = it.arguments!!.getString("url")!!)
            }
        }
    }
}