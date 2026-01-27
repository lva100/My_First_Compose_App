package dev.lva100.myapp.ui.theme

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen() {
    val snackbarHostState = SnackbarHostState()
    val scope = rememberCoroutineScope()
    val fabIsVisible = remember { mutableStateOf(true) }

    Scaffold(
//        containerColor = Color.White,
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        }, floatingActionButton = {
            if (fabIsVisible.value == true) {
            FloatingActionButton(
                onClick = {
                    scope.launch {
                        val action = snackbarHostState.showSnackbar(
                            message = "This is snackbar",
                            actionLabel = "Hide FAB",
                            duration = SnackbarDuration.Long
                        )
                        if (action == SnackbarResult.ActionPerformed) {
                            fabIsVisible.value = false
                        }
                    }
                }) {
                Icon(Icons.Filled.Favorite, contentDescription = null)
            }}
        }, bottomBar = {
            NavigationBar(
//                containerColor = Color(204,204,204,30),
            ) {
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
        Text(text = "123")
    }
}

@Preview
@Composable
fun testUI() {
    VKNewsClientTheme(
        darkTheme = false
    ) {
        MainScreen()
    }
}