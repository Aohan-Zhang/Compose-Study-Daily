package site.aohan.compose_study_daily

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import site.aohan.compose_study_daily.component.WebViewContainer
import site.aohan.compose_study_daily.innerapps.gmailclone.GmailCloneApp
import site.aohan.compose_study_daily.model.NavigationItem
import site.aohan.compose_study_daily.ui.screens.ProfileScreen
import site.aohan.compose_study_daily.ui.screens.StateAndRecompositionScreen
import site.aohan.compose_study_daily.ui.theme.ComposeStudyDailyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeStudyDailyTheme {
//                var title by remember { mutableStateOf(NavEnum.HOME) }
//                var showBack by remember { mutableStateOf(false) }
//
                val navController = rememberNavController()
//                .apply {
//                    // 导航页面发生改变时, 触发回调
//                    addOnDestinationChangedListener { _, destination, _ ->
//                        val route = destination.route.toString()
//                        title = route
//                        showBack = route != NavEnum.HOME
//                    }
//                }

                Surface(
                    modifier = Modifier
                        .fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navigationItemList = mutableListOf(
                        NavigationItem(NavEnum.PROFILE_SCREEN) { ProfileScreen(navController) },
                        NavigationItem(NavEnum.STATE_AND_RECOMPOSITION) {
                            StateAndRecompositionScreen(navController)
                        },
                        NavigationItem(NavEnum.GMAIL) { GmailCloneApp() },
                    )


                    NavHost(
                        navController = navController,
                        startDestination = NavEnum.HOME
                    ) {
                        composable(NavEnum.HOME) {
                            NavigationItemList(
                                navigationItemList = navigationItemList,
                                navController = navController
                            )
                        }
                        composable(
                            NavEnum.WEB_VIEW.toString(),
                            arguments = listOf(
                                navArgument("url") {
                                    type = NavType.StringType
                                    require(true)
                                }
                            )
                        ) {
                            WebViewContainer(url = it.arguments!!.getString("url")!!)
                        }
                        navigationItemList.forEach { navItem ->
                            composable(route = navItem.tag,
                                // 进入动画
                                enterTransition = { slideInVertically { 100 } + fadeIn() },
                                // 退出动画
                                exitTransition = { slideOutVertically { 100 } + fadeOut() }
                            ) {
                                navItem.composable.invoke()
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun NavigationItemList(navigationItemList: List<NavigationItem>, navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        navigationItemList.forEachIndexed { index, item ->
            OutlinedButton(onClick = {
                navController.navigate(item.tag) {
                    item.navOptionBuilder.invoke(this)
                }
            }) {
                Text(text = "${index + 1}.${item.tag}")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewNavigationItemList() {
    val navController = rememberNavController()
    NavigationItemList(
        navigationItemList = listOf(
            NavigationItem(NavEnum.PROFILE_SCREEN) { ProfileScreen(navHostController = navController) },
            NavigationItem(NavEnum.WEB_VIEW.toString()) { ProfileScreen(navHostController = navController) }
        ),
        navController = navController
    )
}