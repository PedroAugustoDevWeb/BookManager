package app.books.infra;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import app.books.dto.MessageErrorDTO;
import app.books.exceptions.ExistingUser;
import app.books.exceptions.NotFoundBook;
import app.books.exceptions.NotFoundUser;
import app.books.exceptions.UserErrorFields;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(NotFoundUser.class)
    public ResponseEntity<?> handleNotFoundUser(NotFoundUser e) {

        MessageErrorDTO messageError =  new MessageErrorDTO(e.getMessage(), HttpStatus.NOT_FOUND, LocalDateTime.now());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(messageError);
    }

    @ExceptionHandler(ExistingUser.class)
    public ResponseEntity<?> handleExisUser(Exception e) {

        MessageErrorDTO messageError =  new MessageErrorDTO(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, LocalDateTime.now());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(messageError);
    }

    @ExceptionHandler(UserErrorFields.class)
    public ResponseEntity<?> handleUserErrorFields(Exception e) {

        MessageErrorDTO messageError =  new MessageErrorDTO(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, LocalDateTime.now());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(messageError);

    }

    @ExceptionHandler(NotFoundBook.class)
    public ResponseEntity<?> handleNotFoundBook(Exception e) {

        MessageErrorDTO messageError =  new MessageErrorDTO(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, LocalDateTime.now());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(messageError);

    }
    
}
