package portfolio.miticode_backend.exceptions;

public class CursoAlreadyExistsException extends RuntimeException{
    public CursoAlreadyExistsException() {
        super("Curso con este nombre ya existe en el sistema.");
    }
}
