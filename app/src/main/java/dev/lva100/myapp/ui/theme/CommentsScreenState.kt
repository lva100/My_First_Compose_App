package dev.lva100.myapp.ui.theme

import dev.lva100.myapp.domain.FeedPost
import dev.lva100.myapp.domain.PostComment

sealed class CommentsScreenState {

    object Initial : CommentsScreenState()

    data class Comments(
        val feedPost: FeedPost,
        val comments: List<PostComment>
    ) : CommentsScreenState()
}