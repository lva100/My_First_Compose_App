package dev.lva100.myapp.ui.theme

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import dev.lva100.myapp.VKNewsMainModel
import dev.lva100.myapp.domain.FeedPost

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(viewModel: VKNewsMainModel) {
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

        val feedPost = viewModel.feedPost.observeAsState(FeedPost())

        PostCard(
            modifier = Modifier.padding(8.dp),
            feedPost = feedPost.value,
            onViewsItemClickListener = viewModel::updateCount,
            onShareItemClickListener = viewModel::updateCount,
            onLikeItemClickListener = {
                viewModel.updateCount(it)
            },
            onCommentItemClickListener = {
                viewModel.updateCount(it)
            },
        )
    }
}