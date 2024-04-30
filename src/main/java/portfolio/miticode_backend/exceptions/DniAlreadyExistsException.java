package portfolio.miticode_backend.exceptions;

public class DniAlreadyExistsException extends RuntimeException {
    public DniAlreadyExistsException() {
        super("El dni ingresado ya está registrado en el sistema");
    }
}
