package app.books.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.books.models.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
    
}
