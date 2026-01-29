package dev.lva100.myapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import dev.lva100.myapp.ui.theme.MainScreen
import dev.lva100.myapp.ui.theme.VKNewsClientTheme

class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<VKNewsMainModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        val viewModel = ViewModelProvider(this)[MainViewModel::class.java]
//        val viewModel = ViewModelProvider(this)[VKNewsMainModel::class.java]
        setContent {
            VKNewsClientTheme {
                MainScreen(viewModel)
            }

//            MyAppTheme() {
//                InstagramProfileCard(viewModel)
//            }

            Test(viewModel = viewModel)
        }
    }
}

@Composable
private fun Test(viewModel: MainViewModel) {
    MyAppTheme() {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
        ) {
            LazyColumn {
                items(500) {
                    InstagramProfileCard(viewModel)
                }
            }
        }
    }
}

