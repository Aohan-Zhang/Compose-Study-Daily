package site.aohan.compose_study_daily.model

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument

sealed class NavigationEnum(
    val route: String,
    val displayName: String,
    val arguments: List<NamedNavArgument> = emptyList()
) {
    data object Home : NavigationEnum("Home", "主页面")
    data object ProfileScreen : NavigationEnum("ProfileScreen", "自述")
    data object StateAndRecomposition : NavigationEnum("StateAndRecomposition", "测试状态和重组")
    data object Gmail : NavigationEnum("Gmail", "仿Gmail")
    data object NewsApp : NavigationEnum("NewsApp", "新闻App")
    data object ToAndroidActivity : NavigationEnum("ToAndroidActivity", "测试compose与xml互相调用")
    data object WebView : NavigationEnum(
        route = "WebView?url={url}",
        displayName = "WebView",
        arguments = listOf(
            navArgument("url") {
                type = NavType.StringType
                require(true)
            }
        )) {
        fun of(url: String) = "WebView?url=$url"
    }
}
