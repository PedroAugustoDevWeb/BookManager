package app.books.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import app.books.models.Author;
import app.books.models.Book;
import app.books.repository.AuthorRepository;
import app.books.repository.BookRepository;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    public String getBooks(String name_book) {

        String apikey = "AIzaSyCmEKqhvA61WQEzOLFmcV7h6a_lUYvF9yA";

        String url = "https://www.googleapis.com/books/v1/volumes?q=" + name_book + "&key=" + apikey;

        RestTemplate restTemplate = new RestTemplate(); 
        
        String result = restTemplate.getForObject(url, String.class);

        return result;

    }

    public String getBook(String id_book) {

        String apikey = "AIzaSyCmEKqhvA61WQEzOLFmcV7h6a_lUYvF9yA";

        String url = "https://www.googleapis.com/books/v1/volumes/" + id_book + "?key=" + apikey;


        RestTemplate restTemplate = new RestTemplate();

        String result = restTemplate.getForObject(url, String.class);

        return result;

    }

    public void saveBook(Book book) {

        Author author = authorRepository.findByName(book.getAuthor().getName());

        if (author == null) {

            authorRepository.save(book.getAuthor());

        } else {

            book.setAuthor(author);

        }

        bookRepository.save(book);
    
    }

    
}
