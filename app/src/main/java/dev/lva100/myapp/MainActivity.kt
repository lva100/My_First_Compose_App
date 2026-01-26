package dev.lva100.myapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.AlertDialogDefaults
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContent {
            TestUI()
//            MyAppTheme {
//                Box(
//                    modifier = Modifier
//                        .fillMaxSize()
//                        .background(MaterialTheme.colorScheme.background)
//                        .padding(8.dp)
//                ) {
//                    PostCard()
//                }
//            }
        }
    }
}

@Composable
private fun ColumnScope.TestText(count: Int, text: String) {
    repeat(count) {
        Text(
            text = text,
            modifier = Modifier.weight(1f)
            )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
private fun TestUI() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {Text(text = "TopAppBar")},
                navigationIcon = {
                    IconButton(
                        onClick = {}
                    ) {
                        Icon(Icons.Filled.Menu, contentDescription = null)
                    }
                }
            )
        },
        bottomBar = {
            BottomAppBar{
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
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
        Text(
            modifier = Modifier.padding(it),
            text = "This is scaffold content"
        )
    }
}

@Composable
private fun Example1() {
    OutlinedButton(
        onClick = {}
    ) {
        Text(text = "Text")
    }
}

@Composable
private fun Example2() {
    TextField(
        value = "value",
        onValueChange = {},
        label = { Text(text = "label") }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun Example3() {
    BasicAlertDialog(
        onDismissRequest = {}
    ) {
        Surface(
            modifier = Modifier
                .wrapContentWidth()
                .wrapContentHeight(),
            shape = MaterialTheme.shapes.large,
            tonalElevation = AlertDialogDefaults.TonalElevation
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text =
                        "This area typically contains the supportive text " +
                                "which presents the details regarding the Dialog's purpose.",
                )
                Spacer(modifier = Modifier.height(24.dp))
                TextButton(
                    onClick = {  },
                    modifier = Modifier.align(Alignment.End)
                ) {
                    Text("Confirm")
                }
            }
        }
    }
}

