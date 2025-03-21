package app.books.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.books.models.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    Author findByName(String name);
    
}
