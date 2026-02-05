package dev.lva100.myapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import dev.lva100.myapp.domain.FeedPost

@Composable
fun AppNavGraph(
    navHostController: NavHostController,
    newsFeedScreenContent: @Composable () -> Unit,
    favouriteScreenContent: @Composable () -> Unit,
    profileScreenContent: @Composable () -> Unit,
    commentsScreenContent: @Composable (FeedPost) -> Unit,
) {
    NavHost(
        navController = navHostController,
        startDestination = Screen.Home.route
    ) {
        homeScreenNavGraph(
            newsFeedScreenContent = newsFeedScreenContent,
            commentsScreenContent = commentsScreenContent
        )
        composable(
            route = Screen.Favourite.route,
        ) {
            favouriteScreenContent()
        }
        composable(
            route = Screen.Profile.route,
        ) {
            profileScreenContent()
        }
    }
}