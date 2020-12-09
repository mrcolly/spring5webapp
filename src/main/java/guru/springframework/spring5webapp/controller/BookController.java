package guru.springframework.spring5webapp.controller;

import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

@RestController
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/books")
    public Set<Book> getBooks() {
        Set<Book> bookSet = new HashSet<>();
        Iterable<Book> bookIter = bookRepository.findAll();
        bookIter.forEach(bookSet::add);

        return bookSet;
    }
}
