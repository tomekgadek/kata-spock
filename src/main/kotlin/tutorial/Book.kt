package io.github.tomekgadek.tutorial

data class Book(val title: String?, val author: String?, val year: Int)

interface BookManagement {

    fun addBook(title: String, author: String, publicationYear: Int)

    fun removeBook(title: String): Boolean

    fun getBooks(): List<Book>
}

open class Library(private val bookManagement: BookManagement) {

    fun borrowBook(title: String): Boolean {
        return bookManagement.removeBook(title)
    }

    fun returnBook(title: String, author: String, publicationYear: Int) {
        bookManagement.addBook(title, author, publicationYear)
    }

    fun allBooks(): List<String> {
        return bookManagement.getBooks().map { it.title as String }
    }
}
