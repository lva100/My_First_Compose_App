package dev.lva100.myapp.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun MainScreen() {
    Scaffold(
        bottomBar = {
            BottomAppBar{
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    val items = listOf(NavigationItem.Home, NavigationItem.Favourite,
                        NavigationItem.Profile)
                    IconButton(onClick = { }) {
                        Icon(Icons.Filled.Favorite, contentDescription = "Избранное")
                    }
                    IconButton(
                        onClick = { },
//                    modifier = Modifier.weight(1f, true)
                    ) {
                        Icon(Icons.Filled.Edit, contentDescription = "Редактировать")
                    }
                    IconButton(onClick = { }) {
                        Icon(Icons.Filled.Delete, contentDescription = "Удалить")
                    }
                }
            }
        }
    ) {

    }
}