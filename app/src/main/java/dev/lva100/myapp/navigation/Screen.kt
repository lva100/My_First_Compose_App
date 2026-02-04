package dev.lva100.myapp.navigation

import dev.lva100.myapp.domain.FeedPost

sealed class Screen(
    val route: String
) {
    object NewsFeed : Screen(ROUTE_NEWS_FEED)
    object Favourite : Screen(ROUTE_FAVOURITE)
    object Profile : Screen(ROUTE_PROFILE)
    object Home : Screen(ROUTE_HOME)
    object Comments : Screen(ROUTE_COMMENTS) {
        private const val ROUTE_FOR_ARGS = "comments"
        fun getRouteWithArgs(feedPost: FeedPost): String {
            return "$ROUTE_FOR_ARGS/${feedPost.id}"
        }
    }

    private companion object {
        const val ROUTE_HOME = "home"
        const val ROUTE_COMMENTS = "comments/{feed_post_id}"
        const val ROUTE_NEWS_FEED = "news_feed"
        const val ROUTE_FAVOURITE = "favourite"
        const val ROUTE_PROFILE = "profile"
    }
}