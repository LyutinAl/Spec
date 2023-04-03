package ru.ps.spec_;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.ps.spec_.exception.*;

import java.util.Collections;

@ControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler({DictionaryElementNotFoundException.class, StandardNotFoundByIdException.class,
            StandardNotFoundByDictionaryIdException.class})
    public ResponseEntity<Object> handlerDictionaryElementNotFoundException(IllegalArgumentException ex) {
        ErrorResponse error = new ErrorResponse(Collections.singletonList(ex.getMessage()));
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(SomeChildHasStandardException.class)
    public ResponseEntity<Object> handlerSomeChildHasStandardException(IllegalStateException ex) {
        ErrorResponse error = new ErrorResponse(Collections.singletonList(ex.getMessage()));
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
