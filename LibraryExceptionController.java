package org.uplift.libraryproject.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.uplift.libraryproject.exception.HolidayApiException;
import org.uplift.libraryproject.exception.InvalidHolidayApiInputException;
import org.uplift.libraryproject.exception.LibraryClosedException;
import org.uplift.libraryproject.model.HolidayApiResponse;

@ControllerAdvice
public class LibraryExceptionController {
    @ExceptionHandler(value = LibraryClosedException.class)
    public ResponseEntity<Object> handleLibraryCloseEcception(LibraryClosedException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.SERVICE_UNAVAILABLE);
    }

    @ExceptionHandler(value = HolidayApiException.class)
    public ResponseEntity<Object> handleHolidayApiException(HolidayApiException e){
        return  new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value= InvalidHolidayApiInputException.class)
    public ResponseEntity<Object> handleInvalidHolidayApiInputException(InvalidHolidayApiInputException e){
        return  new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
