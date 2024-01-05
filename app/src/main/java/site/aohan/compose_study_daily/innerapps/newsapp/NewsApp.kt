package site.aohan.compose_study_daily.innerapps.newsapp

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import site.aohan.compose_study_daily.component.WebViewContainer
import site.aohan.compose_study_daily.innerapps.newsapp.component.BottomMenuBar
import site.aohan.compose_study_daily.innerapps.newsapp.component.newsAppBottomBar
import site.aohan.compose_study_daily.innerapps.newsapp.config.Route
import site.aohan.compose_study_daily.innerapps.newsapp.model.BottomBarItemModel
import site.aohan.compose_study_daily.model.NavigationEnum

@Composable
fun NewsApp() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomMenuBar(navController) }
    ) { padding ->
        NavHost(navController = navController, startDestination = BottomBarItemModel.Home.route) {

            newsAppBottomBar(padding, navController)

            composable(Route.NewsAppDetail) {

            }

            composable(NavigationEnum.WebView.route, arguments = NavigationEnum.WebView.arguments) {
                WebViewContainer(url = it.arguments!!.getString("url")!!)
            }
        }
    }
}
