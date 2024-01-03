package site.aohan.compose_study_daily.innerapps.newsapp.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch
import site.aohan.compose_study_daily.innerapps.newsapp.component.NewsAppLoading
import site.aohan.compose_study_daily.innerapps.newsapp.component.NewsList
import site.aohan.compose_study_daily.innerapps.newsapp.data.NewsRepository
import site.aohan.compose_study_daily.innerapps.newsapp.model.NewsModel

@Suppress("UNUSED_PARAMETER")
@Composable
fun HomeScreen(modifier: Modifier = Modifier, navController: NavHostController) {
    var showLoading by remember { mutableStateOf(false) }
    // 保存状态, 否则每次进入次方法就会触发重新加载
    var newsState by rememberSaveable { mutableStateOf<List<NewsModel>>(listOf()) }
    LaunchedEffect(Unit) {
        if (newsState.isNotEmpty()) return@LaunchedEffect
        launch {
            showLoading = true
            val model = NewsRepository.fakeGetNewsFromJuhe()
            newsState = model
            showLoading = false
        }
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        NewsList(modifier = Modifier.padding(horizontal = 10.dp), news = newsState, navController)
        if (showLoading) {
            NewsAppLoading()
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewHomeScreen() {
    HomeScreen(navController = rememberNavController())
}

