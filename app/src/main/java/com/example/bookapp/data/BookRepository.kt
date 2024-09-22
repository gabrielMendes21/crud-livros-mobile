package com.example.bookapp.data

import kotlinx.coroutines.flow.Flow

open class BookRepository(private val bookDao: BookDao) {
    fun getAllBooks(): Flow<List<Book>> = bookDao.getAllBooks()

    fun getBookById(id: Int): Flow<Book> = bookDao.getBookById(id)

    suspend fun insertBook(book: Book) = bookDao.insertBook(book)

    suspend fun deleteBook(book: Book) = bookDao.deleteBook(book)
}
