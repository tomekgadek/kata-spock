package tutorial

import io.github.tomekgadek.tutorial.Book
import io.github.tomekgadek.tutorial.BookManagement
import io.github.tomekgadek.tutorial.Library
import spock.lang.Specification

class BookSpec extends Specification {

    def "should borrow book from library using Stub verification"() {

        given: "library with 3 books"
        def bookManagement = Stub(BookManagement)
        def bookLibrary = new Library(bookManagement)

        bookManagement.getBooks() >> [
                new Book("1984", "George Orwell", 1949),
                new Book("Clean Code", "Robert C. Martin", 2008),
                new Book("The Pragmatic Programmer", "Andrew Hunt", 1999)
        ]

        when:
        bookManagement.removeBook("1984") >> true
        bookManagement.getBooks().remove(0)
        and:
        def isBorrowed = bookLibrary.borrowBook("1984")

        then: "book is borrowed"
        isBorrowed
        and: "books are available"
        bookLibrary.allBooks() == ["Clean Code", "The Pragmatic Programmer"]
    }

    def "should borrow book from library using Mock verification"() {

        given: "library with 3 books"
        def bookManagement = Mock(BookManagement)
        def bookLibrary = new Library(bookManagement)

        bookManagement.getBooks() >> [
                new Book("1984", "George Orwell", 1949),
                new Book("Clean Code", "Robert C. Martin", 2008),
                new Book("The Pragmatic Programmer", "Andrew Hunt", 1999)
        ]

        when:
        def isBorrowed = bookLibrary.borrowBook("1984")
        and:
        bookManagement.getBooks().remove(0)

        then: "book is borrowed"
        isBorrowed
        and: "Mock interactions verification"
        1 * bookManagement.removeBook("1984") >> true
        0 * bookManagement.removeBook("Clean Code")
        0 * bookManagement.removeBook("The Pragmatic Programmer")

        and: "books list updated"
        bookLibrary.allBooks().size() == 2
    }
}
