package com.example.bookapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.bookapp.ui.BookViewModelFactory
import com.example.bookapp.ui.HomeScreen
import com.example.bookapp.data.BookRepository
import com.example.bookapp.ui.BookViewModel
import com.example.bookapp.ui.BookScreen

@Composable
fun BookNavGraph(navController: NavHostController, bookRepository: BookRepository) {
    val viewModel: BookViewModel = viewModel(factory = BookViewModelFactory(bookRepository))

    NavHost(navController, startDestination = "homeScreen") {
        composable("homeScreen") { HomeScreen(navController) }
        composable("bookScreen") { BookScreen(viewModel) }
    }
}
