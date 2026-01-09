package dev.lva100.myapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import dev.lva100.myapp.ui.theme.MyAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContent {
            UserInfo(name = "Vitaly", age = 44)
        }
    }
}
@Preview
@Composable
fun Greeting() {
    val name = "John"
    Text(
        text = "Hello $name!",
        color = Color.Blue
    )
}
@Preview
@Composable
fun UserInfoPreview() {
    UserInfo("John", age = 25)
}

@Composable
fun UserInfo(name: String, age: Int) {
    Column() {
        repeat(10) {
            Text(text = "Hello $name! Your are $age years old")
        }
//        for(n in 1..10) {
//            Text(text = "Hello $name! Your are $age years old")
//        }
    }
}