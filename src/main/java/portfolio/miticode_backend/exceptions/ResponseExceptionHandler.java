package portfolio.miticode_backend.exceptions;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ResponseExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
        Map<String, Object> errors = e.getBindingResult()
                .getAllErrors()
                .stream()
                .collect(Collectors.toMap(error -> ((FieldError) error).getField(), DefaultMessageSourceResolvable::getDefaultMessage));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }

    @ExceptionHandler(ModelNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleModelNotFoundException(ModelNotFoundException e){
        int statusCode = HttpStatus.NOT_FOUND.value();
        ErrorResponse errorResponse = new ErrorResponse(statusCode, e.getMessage());
        return ResponseEntity.status(statusCode).body(errorResponse);
    }

    @ExceptionHandler(ModelAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> handleModelAlreadyExistsException(ModelAlreadyExistsException e){
        int statusCode = HttpStatus.CONFLICT.value();
        ErrorResponse errorResponse = new ErrorResponse(statusCode, e.getMessage());
        return ResponseEntity.status(statusCode).body(errorResponse);
    }
}
