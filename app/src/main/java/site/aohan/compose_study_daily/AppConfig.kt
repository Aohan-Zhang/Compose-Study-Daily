package site.aohan.compose_study_daily

object NavEnum {
    const val HOME = "Home"
    const val PROFILE_SCREEN = "ProfileScreen"
    const val STATE_AND_RECOMPOSITION = "StateAndRecomposition"
    const val GMAIL = "Gmail"

    @Suppress("ClassName")
    object WEB_VIEW {
        fun of(url: String) = "WEB_VIEW?url=$url"

        override fun toString(): String {
            return "WEB_VIEW?url={url}"
        }
    }
}