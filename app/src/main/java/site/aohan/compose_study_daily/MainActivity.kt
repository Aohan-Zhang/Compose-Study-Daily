package site.aohan.compose_study_daily

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import site.aohan.compose_study_daily.component.OutlinedTextButton
import site.aohan.compose_study_daily.component.WebViewContainer
import site.aohan.compose_study_daily.innerapps.gmailclone.GmailCloneApp
import site.aohan.compose_study_daily.innerapps.newsapp.NewsApp
import site.aohan.compose_study_daily.model.NavigationEnum.Gmail
import site.aohan.compose_study_daily.model.NavigationEnum.Home
import site.aohan.compose_study_daily.model.NavigationEnum.NewsApp
import site.aohan.compose_study_daily.model.NavigationEnum.ProfileScreen
import site.aohan.compose_study_daily.model.NavigationEnum.StateAndRecomposition
import site.aohan.compose_study_daily.model.NavigationEnum.ToAndroidActivity
import site.aohan.compose_study_daily.model.NavigationEnum.WebView
import site.aohan.compose_study_daily.ui.activity.TestComposeToActivity
import site.aohan.compose_study_daily.ui.screens.ProfileScreen
import site.aohan.compose_study_daily.ui.screens.StateAndRecompositionScreen
import site.aohan.compose_study_daily.ui.theme.ComposeStudyDailyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeStudyDailyTheme {
                val navController = rememberNavController()
                Surface(
                    modifier = Modifier
                        .fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavHost(
                        navController = navController,
                        startDestination = Home.route,
                        // 进入动画
                        enterTransition = { slideInVertically { 100 } + fadeIn() },
                        // 退出动画
                        exitTransition = { slideOutVertically { 100 } + fadeOut() }
                    ) {

                        // home
                        composable(Home.route) {
                            NavigationItemList(navController = navController)
                        }
                        composable(route = ProfileScreen.route) {
                            ProfileScreen(navController)
                        }
                        composable(route = StateAndRecomposition.route) {
                            StateAndRecompositionScreen()
                        }
                        composable(route = Gmail.route) {
                            GmailCloneApp()
                        }
                        composable(route = NewsApp.route) {
                            NewsApp()
                        }
                        composable(
                            route = WebView.route,
                            arguments = listOf(
                                navArgument("url") {
                                    type = NavType.StringType
                                    require(true)
                                }
                            )
                        ) {
                            WebViewContainer(url = it.arguments!!.getString("url")!!)
                        }
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun NavigationItemList(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        val context = LocalContext.current

        FlowRow(
            modifier = Modifier.padding(horizontal = 10.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            listOf(ProfileScreen, StateAndRecomposition, Gmail, NewsApp).forEach {
                OutlinedTextButton(text = it.displayName) {
                    navController.navigate(it.route)
                }
            }
            OutlinedTextButton(text = ToAndroidActivity.displayName) {
                context.startActivity(Intent(context, TestComposeToActivity::class.java))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewNavigationItemList() {
    NavigationItemList(navController = rememberNavController())
}