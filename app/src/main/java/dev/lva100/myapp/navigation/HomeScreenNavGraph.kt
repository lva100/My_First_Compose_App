package dev.lva100.myapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import dev.lva100.myapp.domain.FeedPost

fun NavGraphBuilder.homeScreenNavGraph(
    newsFeedScreenContent: @Composable () -> Unit,
    commentsScreenContent: @Composable (FeedPost) -> Unit,
) {
    navigation(
        startDestination = Screen.NewsFeed.route,
        route = Screen.Home.route
    ) {
        composable(
            route = Screen.NewsFeed.route,
        ) {
            newsFeedScreenContent()
        }
        composable(
            route = Screen.Comments.route,
        ) {
            val feedPostId = it.arguments?.getInt("feed_post_id") ?: 0
            commentsScreenContent(FeedPost(id = feedPostId))
        }
    }
}