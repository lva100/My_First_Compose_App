package dev.lva100.myapp.ui.theme

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import dev.lva100.myapp.VKNewsViewModel
import dev.lva100.myapp.domain.PostComment

@Composable
fun HomeScreen(
    viewModel: VKNewsViewModel,
    paddingValues: PaddingValues
) {
    val feedPosts = viewModel.feedPosts.observeAsState(listOf())

    if (feedPosts.value.isNotEmpty()) {
        val comments = mutableListOf<PostComment>().apply {
            repeat(20) {
                add(
                    PostComment(id = it)
                )
            }
        }
        CommentsScreen(
            feedPosts.value.get(0),
            comments = comments
        )
    }


    /*
    LazyColumn(
        modifier = Modifier.padding(paddingValues),
        contentPadding = PaddingValues(
            top = 16.dp,
            start = 8.dp,
            end = 8.dp,
            bottom = 16.dp
        ),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    )
    {
        items(
            items = feedPosts.value,
            key = { it.id }
        ) { feedPost ->
            val dismissState = rememberSwipeToDismissBoxState()
            SwipeToDismissBox(
                modifier = Modifier.animateItem(),
                state = dismissState,
                enableDismissFromStartToEnd = false,
                backgroundContent = {
                    Box(
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxSize()
                            .background(Color.Red.copy(alpha = 0.5f)),
                        contentAlignment = Alignment.CenterEnd
                    ) {
                        Text(
                            modifier = Modifier.padding(16.dp),
                            text = "Delete Item",
                            color = Color.White,
                            fontSize = 24.sp
                        )
                    }
                },
                onDismiss = {
                    viewModel.remove(feedPost)
                }
            ) {
                PostCard(
                    feedPost = feedPost,
                    onViewsItemClickListener = { statisticItem ->
                        viewModel.updateCount(feedPost, statisticItem)
                    },
                    onShareItemClickListener = { statisticItem ->
                        viewModel.updateCount(feedPost, statisticItem)
                    },
                    onLikeItemClickListener = { statisticItem ->
                        viewModel.updateCount(feedPost, statisticItem)
                    },
                    onCommentItemClickListener = { statisticItem ->
                        viewModel.updateCount(feedPost, statisticItem)
                    },
                )
            }
        }
    }*/
}