package site.aohan.compose_study_daily

object NavEnum {
    const val HOME = "HOME"
    const val PROFILE_SCREEN = "PROFILE_SCREEN"

    @Suppress("ClassName")
    object WEB_VIEW {
        fun of(url: String) = "WEB_VIEW?url=$url"

        override fun toString(): String {
            return "WEB_VIEW?url={url}"
        }
    }
}