package dev.lva100.myapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dev.lva100.myapp.domain.FeedPost
import dev.lva100.myapp.domain.StatisticItem
import dev.lva100.myapp.ui.theme.HomeScreenState

class VKNewsViewModel : ViewModel() {
    private val sourceList = mutableListOf<FeedPost>().apply {
        repeat(10) {
            add(FeedPost(id = it))
        }
    }
    private val initialState = HomeScreenState.Posts(posts = sourceList)
    private val _screenState = MutableLiveData<HomeScreenState>(initialState)
    val screenState: LiveData<HomeScreenState> = _screenState
    fun updateCount(feedPost: FeedPost, item: StatisticItem) {
        val oldPosts = screenState.value?.toMutableList() ?: throw IllegalStateException()
        val oldStatistics = feedPost.statistics
        val newStatistics = oldStatistics.toMutableList().apply {
            replaceAll { oldItem ->
                if (oldItem.type == item.type) {
                    oldItem.copy(count = oldItem.count + 1)
                } else {
                    oldItem
                }
            }
        }
        val newFeedPost = feedPost.copy(statistics = newStatistics)
        _screenState.value = oldPosts.apply {
            replaceAll {
                if (it.id == newFeedPost.id) {
                    newFeedPost
                } else {
                    it
                }
            }
        }

    }

    fun remove(feedPost: FeedPost) {
        val oldPosts = screenState.value?.toMutableList() ?: mutableListOf()
        oldPosts.remove(feedPost)
        _screenState.value = oldPosts
    }
}
