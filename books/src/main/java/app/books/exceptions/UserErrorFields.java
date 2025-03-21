package app.books.exceptions;

public class UserErrorFields extends RuntimeException {
    
    public UserErrorFields() {
        super("Campos inválidos");
    }

    public UserErrorFields(String message) {
        super(message);
    }
    
}
