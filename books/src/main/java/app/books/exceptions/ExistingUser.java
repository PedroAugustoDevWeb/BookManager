package app.books.exceptions;


public class ExistingUser extends RuntimeException {
    
    public ExistingUser() {
        super("Usuário já cadastrado");
    }

    public ExistingUser(String message) {
        super(message);
    }
}


