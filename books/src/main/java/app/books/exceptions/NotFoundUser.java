package app.books.exceptions;

public class NotFoundUser extends RuntimeException {
    
    public NotFoundUser() {
        super("Usuario não encontrado");
    }

    public NotFoundUser(String message) {
        super(message);
    }

}
