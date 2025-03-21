package app.books.exceptions;

public class NotFoundBook extends RuntimeException {
    
    public NotFoundBook() {
        super("Livro não encontrado");
    }

    public NotFoundBook(String message) {
        super(message);
    }
    
}
