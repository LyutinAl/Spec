package ru.ps.spec_;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.ps.spec_.exception.*;

import java.util.Collections;

@Slf4j
@ControllerAdvice
@AllArgsConstructor
public class ApplicationExceptionHandler {

    private final ObjectMapper objectMapper;

    /**
     * Processing of exceptions when some element not found
     *
     * @param ex - exception
     * @return (ResponseEntity<Object>) - error response
     * @throws JsonProcessingException - exception
     */
    @ExceptionHandler({DictionaryElementNotFoundException.class, StandardNotFoundByIdException.class,
            StandardNotFoundByDictionaryIdException.class, DictionaryIsEmptyException.class,
            DictionaryElementNotFoundByParentIdException.class})
    public ResponseEntity<Object> handleElementNotFoundException(RuntimeException ex) throws JsonProcessingException {
        ErrorResponse error = new ErrorResponse(Collections.singletonList(ex.getMessage()));
        log.error(objectMapper.writeValueAsString(error));
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    /**
     * Processing of exceptions when standard with dictionary id already exist
     *
     * @param ex - exception
     * @return (ResponseEntity<Object>) - error response
     * @throws JsonProcessingException - exception
     */
    @ExceptionHandler({StandardWithDictionaryIdAlreadyExistException.class})
    public ResponseEntity<Object> handleStandardWithDictionaryIdAlreadyExistException(RuntimeException ex) throws JsonProcessingException {
        ErrorResponse error = new ErrorResponse(Collections.singletonList(ex.getMessage()));
        log.error(objectMapper.writeValueAsString(error));
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }

    /**
     * Processing of exceptions when some child in cascade has standard
     *
     * @param ex - exception
     * @return (ResponseEntity<Object>) - error response
     * @throws JsonProcessingException - exception
     */
    @ExceptionHandler(SomeChildHasStandardException.class)
    public ResponseEntity<Object> handleSomeChildHasStandardException(RuntimeException ex) throws JsonProcessingException {
        ErrorResponse error = new ErrorResponse(Collections.singletonList(ex.getMessage()));
        log.error(objectMapper.writeValueAsString(error));
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}