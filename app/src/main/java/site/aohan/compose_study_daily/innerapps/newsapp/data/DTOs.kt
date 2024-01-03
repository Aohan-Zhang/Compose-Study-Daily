@file:Suppress("PropertyName")

package site.aohan.compose_study_daily.innerapps.newsapp.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import site.aohan.compose_study_daily.innerapps.newsapp.model.NewsModel

@Serializable
data class NewsFromBjbDTO(

//    val lj: String,
//    val zt: Int,
    /** 头图链接 */
    @SerialName("tp")
    val topPic: String,
    /** 联系方式 */
    @SerialName("lx")
    val contact: String,
    /** 新闻内容 */
    @SerialName("wb")
    val news: List<List<String>>
) {
    fun toModels() = news.map {
        NewsModel(title = it[0], originUrl = it[1])
    }
}

@Serializable
data class NewsFromJuheDTO(
    val error_code: Int,
    val reason: String,
    val result: Result
) {
    @Serializable
    data class Result(
        val `data`: List<Data>,
    ) {
        @Serializable
        data class Data(
            val author_name: String,
            val category: String,
            val date: String,
            val thumbnail_pic_s: String? = null,
            val thumbnail_pic_s02: String? = null,
            val thumbnail_pic_s03: String? = null,
            val title: String,
            val url: String
        )
    }

    fun toModels() = result.data.map { data ->
        val pictures = listOf(
            data.thumbnail_pic_s,
            data.thumbnail_pic_s02,
            data.thumbnail_pic_s03,
        ).filter { !it.isNullOrEmpty() }.map { it!! }
        NewsModel(title = data.title, originUrl = data.url, pictures = pictures)
    }.filter {
        it.pictures.isNotEmpty()
    }

}