package site.aohan.compose_study_daily.innerapps.newsapp.model

data class NewsModel(
    val title: String = "",
    val content: String = "",
    val pictures: List<String> = listOf(),
    val originUrl: String = ""
)