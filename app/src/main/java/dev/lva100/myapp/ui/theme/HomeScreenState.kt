package dev.lva100.myapp.ui.theme

import dev.lva100.myapp.domain.FeedPost
import dev.lva100.myapp.domain.PostComment

sealed class HomeScreenState {

    object Initial : HomeScreenState()

    data class Posts(
        val posts: List<FeedPost>
    ) : HomeScreenState()

    data class Comments(
        val feedPost: FeedPost,
        val comments: List<PostComment>
    ) : HomeScreenState()
}