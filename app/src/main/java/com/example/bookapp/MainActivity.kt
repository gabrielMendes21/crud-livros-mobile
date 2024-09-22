package com.example.bookapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.bookapp.data.AppContainer
import com.example.bookapp.ui.navigation.BookNavGraph
import com.example.bookapp.ui.theme.BookAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BookAppTheme{

                val appContainer = AppContainer(applicationContext)
                val bookRepository = appContainer.bookRepository
                val navController = rememberNavController()
                BookNavGraph(navController = navController, bookRepository = bookRepository)            }
        }
    }
}
