package dev.lva100.myapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import dev.lva100.myapp.ui.theme.MainScreen
import dev.lva100.myapp.ui.theme.VKNewsClientTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        setContent {
            VKNewsClientTheme {
                MainScreen()
            }

//            MyAppTheme() {
//                InstagramProfileCard(viewModel)
//            }
        }
    }
}

