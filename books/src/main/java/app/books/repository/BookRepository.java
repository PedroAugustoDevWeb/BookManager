package app.books.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import app.books.models.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByAuthorId(Long authorId);

    List<Book> findByUserId(Long userId);
    
}
