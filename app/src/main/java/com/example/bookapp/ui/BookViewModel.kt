package com.example.bookapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bookapp.data.BookRepository
import com.example.bookapp.data.Book
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class BookViewModel(private val repository: BookRepository) : ViewModel() {

    val bookList: Flow<List<Book>> = repository.getAllBooks()

    fun getBookById(id: Int): Flow<Book> = repository.getBookById(id)

    fun addOrUpdateBook(id: Int? = null, title: String, pub_year: Int, author: String, genre: String, publisher: String) {
        val book = Book(id = id ?: 0, title = title,  pub_year = pub_year, author = author, genre = genre, publisher = publisher)
        viewModelScope.launch {
            repository.insertBook(book)
        }
    }

    fun deleteBook(book: Book) {
        viewModelScope.launch {
            repository.deleteBook(book)
        }
    }
}
