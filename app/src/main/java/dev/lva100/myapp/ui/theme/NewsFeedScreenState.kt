package dev.lva100.myapp.ui.theme

import dev.lva100.myapp.domain.FeedPost

sealed class NewsFeedScreenState {

    object Initial : NewsFeedScreenState()

    data class Posts(
        val posts: List<FeedPost>
    ) : NewsFeedScreenState()
}