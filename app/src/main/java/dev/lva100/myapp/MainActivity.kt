package dev.lva100.myapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import dev.lva100.myapp.ui.theme.InstagramProfileCard
import dev.lva100.myapp.ui.theme.MyAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel = ViewModelProvider(this)[MainViewModel::class.java]
//        enableEdgeToEdge()
        setContent {
//            VKNewsClientTheme {
//                MainScreen()
//            }

            MyAppTheme() {
                InstagramProfileCard(viewModel)
            }
        }
    }
}

