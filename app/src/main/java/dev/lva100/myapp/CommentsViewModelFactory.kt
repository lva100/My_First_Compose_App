package dev.lva100.myapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dev.lva100.myapp.domain.FeedPost

class CommentsViewModelFactory(
    private val feedPost: FeedPost
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CommentsViewModel(feedPost) as T
    }
}