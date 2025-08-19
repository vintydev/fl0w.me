package dev.vinty.fl0w.exception;

import dev.vinty.fl0w.dto.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/** * Global exception handler for handling exceptions across the application.
 * This class will be used to define methods that handle specific exceptions
 * and return appropriate HTTP responses.
 */
@ControllerAdvice // Allow this class to handle exceptions globally across controllers
public class GlobalExceptionHandler {

    /**  Handles ResourceNotFoundException and returns a 404 Not Found response.
     *
     * @param e the ResourceNotFoundException that was thrown
     * @return a ResponseEntity with an ErrorMessage and HTTP status 404 Not Found
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleResourceNotFoundException(ResourceNotFoundException e){

        ErrorMessage errorMessage = new ErrorMessage("NOT_FOUND", e.getMessage());

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND).body(errorMessage);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> handleGenericException(Exception e) {

        ErrorMessage errorMessage = new ErrorMessage("INTERNAL_SERVER_ERROR", "An unexpected error occurred. Please try again.");

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
    }
}
