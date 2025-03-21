package app.books.controller;

import org.hibernate.annotations.Struct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.books.models.Book;
import app.books.services.BookService;

@RestController
@RequestMapping("api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("search/{name_book}")
    public ResponseEntity searchBooks(@PathVariable String name_book) {

        
        return ResponseEntity.ok(bookService.getBooks(name_book));
    }

    @GetMapping("search/book/{id_book}")
    public String getBook(@PathVariable String id_book) {

        return bookService.getBook(id_book);

    }

    @PostMapping("book/save")
    public void createBook(@RequestBody @Validated Book book) {

        bookService.saveBook(book);

    }



    
}
