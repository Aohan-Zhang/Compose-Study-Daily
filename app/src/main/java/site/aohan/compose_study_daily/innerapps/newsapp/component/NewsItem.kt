package site.aohan.compose_study_daily.innerapps.newsapp.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.size.Scale
import site.aohan.compose_study_daily.NavEnum
import site.aohan.compose_study_daily.innerapps.newsapp.model.NewsModel

@Composable
fun NewsList(
    modifier: Modifier = Modifier,
    news: List<NewsModel>,
    navController: NavHostController
) {
    if (news.isEmpty()) {
        return
    }

    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        item {
            Spacer(modifier = Modifier.height(10.dp))
        }
        items(news) {
            NewsItem(
                modifier = Modifier.clickable {
                    navController.navigate(NavEnum.WEB_VIEW.of(it.originUrl))
                },
                title = it.title,
                picUrls = it.pictures
            )
        }
        item {
            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}

@Composable
fun NewsItem(modifier: Modifier = Modifier, title: String, picUrls: List<String>) {
    Card(
        modifier = modifier,
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 10.dp)
    ) {
        ConstraintLayout {
            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                model = ImageRequest.Builder(LocalContext.current)
                    .data(picUrls[0])
                    .scale(Scale.FILL)
                    // 加载完成之前交叉淡入淡出动画
                    .crossfade(true)
                    .build(),
                contentDescription = null,
                contentScale = ContentScale.FillWidth
            )
            val text = createRef()
            Text(
                text = title,
                style = TextStyle(
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp
                ),
                modifier = Modifier
                    .padding(10.dp)
                    .constrainAs(text) {
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                    }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewNewsItem() {
    NewsItem(
        title = "1、据报道，截至1月1日19时8分，2024年元旦档（2023年12月30日—2024年1月1日）新片总票房突破15亿元。",
        picUrls = listOf("http://bjb.yunwj.top/php/60miao/2.jpg")
    )
}