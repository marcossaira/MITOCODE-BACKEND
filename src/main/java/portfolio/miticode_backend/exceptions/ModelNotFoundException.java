package portfolio.miticode_backend.exceptions;

public class ModelNotFoundException extends RuntimeException{
    public ModelNotFoundException() {
        super("Recurso no existe");
    }
}
