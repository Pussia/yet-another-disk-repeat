package ru.pasha.yetAnotherDiskRepeat.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.pasha.yetAnotherDiskRepeat.reponse.Response;

@ControllerAdvice
public class CustomExceptionsHandler {

    @ExceptionHandler(value = ValidationException.class)
    public ResponseEntity<Response> handleValidationException(ValidationException e) {
        Response response = new Response(HttpStatus.BAD_REQUEST.value(), e.getMessage());

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = SystemItemNotFoundException.class)
    public ResponseEntity<Response> handleValidationException(SystemItemNotFoundException e) {
        Response response = new Response(HttpStatus.NOT_FOUND.value(), e.getMessage());

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
