package com.olidev.pe.demo.errors;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice // Programación orientada a aspectos.
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handlerMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        var errors = exception.getFieldErrors().stream().map(DataErrorValidation::new).toList();
        return ResponseEntity.badRequest().body(errors);
    }

    public record DataErrorValidation(String campo, String error) {
        public DataErrorValidation(FieldError error) {
            this(error.getField(), error.getDefaultMessage());
        }
    }

    /*
    Output Postman Example:
    [
        {
            "campo": "apellido",
            "error": "apellido no puede ser nulo o vacío"
        },
        {
            "campo": "nombre",
            "error": "nombre no puede ser nulo o vacío"
        }
    ]
     */

    /*
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handlerMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        Map<String, String> mapErrors = new HashMap<>();
        exception.getBindingResult().getAllErrors().forEach((error) -> {
            String clave = ((FieldError) error).getField();
            String valor = error.getDefaultMessage();
            mapErrors.put(clave, valor);
        });
        return new ResponseEntity<>(mapErrors, HttpStatus.BAD_REQUEST);
    }
    Output Postman Example:
    {
        "apellido": "apellido no puede ser nulo o vacío",
        "nombre": "nombre no puede ser nulo o vacío"
    }
     */

}
