package org.example.inventory.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GenericException {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception e){
        ErrorResponse errorResponse = new ErrorResponse(LocalDateTime.now(),"server side error",e.getMessage());
        return  new ResponseEntity<>(errorResponse,HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> handleRuntimeException(RuntimeException e){
        ErrorResponse errorResponse = new ErrorResponse(LocalDateTime.now(),"server runtime error",e.getMessage());
        return  new ResponseEntity<>(errorResponse,HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<?> handleProductNotFoundException(ProductNotFoundException e){
        ErrorResponse errorResponse = new ErrorResponse(LocalDateTime.now(),"product not found",e.getMessage());
        return  new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(ReceiptNotFound.class)
    public ResponseEntity<?> handleReceiptNotFound(ReceiptNotFound e){
        ErrorResponse errorResponse = new ErrorResponse(LocalDateTime.now(),"Receipt not found",e.getMessage());
        return  new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
    }

}
