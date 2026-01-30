package dev.lva100.myapp.ui.theme

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SwipeToDismissBox
import androidx.compose.material3.Text
import androidx.compose.material3.rememberSwipeToDismissBoxState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.lva100.myapp.VKNewsViewModel
import dev.lva100.myapp.domain.FeedPost

@Composable
fun MainScreen(viewModel: VKNewsViewModel) {

    val feedPost = remember {
        mutableStateOf(FeedPost())
    }

    Scaffold(
        bottomBar = {
            NavigationBar {
                Log.d("COMPOSE_TEST", "BottomNavigation")

                val selectedItemPosition = remember { mutableStateOf(0) }

                val items = listOf(
                    NavigationItem.Home, NavigationItem.Favourite, NavigationItem.Profile
                )
                items.forEachIndexed { index, item ->
                    NavigationBarItem(
                        onClick = { selectedItemPosition.value = index },
                        selected = selectedItemPosition.value == index,
                        icon = {
                            Icon(item.icon, contentDescription = null)
                        },
                        label = {
                            Text(text = stringResource(id = item.titleResId))
                        },
                        colors = NavigationBarItemColors(
                            selectedIconColor = MaterialTheme.colorScheme.onPrimary,
                            selectedTextColor = MaterialTheme.colorScheme.onPrimary,
                            selectedIndicatorColor = Color(234, 221, 255, 255),
                            unselectedIconColor = MaterialTheme.colorScheme.onSecondary,
                            unselectedTextColor = MaterialTheme.colorScheme.onSecondary,
                            disabledIconColor = Color.LightGray,
                            disabledTextColor = Color.LightGray,
                        )
                    )
                }

            }
        }) {
        val feedPosts = viewModel.feedPosts.observeAsState(listOf())

        LazyColumn(
            modifier = Modifier.padding(it),
            contentPadding = PaddingValues(
                top = 16.dp,
                start = 8.dp,
                end = 8.dp,
                bottom = 142.dp
            ),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
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
        }
    }
}