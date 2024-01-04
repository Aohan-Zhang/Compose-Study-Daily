package site.aohan.compose_study_daily.innerapps.newsapp

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import site.aohan.compose_study_daily.component.WebViewContainer
import site.aohan.compose_study_daily.innerapps.newsapp.config.Route
import site.aohan.compose_study_daily.innerapps.newsapp.screens.HomeScreen
import site.aohan.compose_study_daily.model.NavigationEnum

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

            composable(NavigationEnum.WebView.route, arguments = NavigationEnum.WebView.arguments) {
                WebViewContainer(url = it.arguments!!.getString("url")!!)
            }
        }
    }
}