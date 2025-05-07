package de.ait.hw20250507_1.controllers;


import de.ait.hw20250507_1.model.Author;
import de.ait.hw20250507_1.model.Book;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookController {
    private static List<Book> booksDb = new ArrayList<>(
            List.of(
                    new Book(new Author("Lew", "Tolstoy"), "War and freedom"),
                    new Book(new Author("Vladimir", "Nabokow"), "Lolita"))
    );


    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public List<Book> getBooks() {
        return booksDb;
    }

    @RequestMapping(value="/books", method = RequestMethod.PUT)
    public void updateBook() {
        System.out.println("put!!!");
    }
}
