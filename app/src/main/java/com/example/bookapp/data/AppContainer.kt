package com.example.bookapp.data

import android.content.Context
import androidx.room.Room

class AppContainer(context: Context) {
    private val database: BookDatabase by lazy {
        Room.databaseBuilder(context, BookDatabase::class.java, "bd_book").build()
    }

    val bookRepository: BookRepository by lazy {
        BookRepository(database.bookDao())
    }
}