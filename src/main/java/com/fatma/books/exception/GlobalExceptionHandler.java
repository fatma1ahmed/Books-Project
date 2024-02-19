package com.fatma.books.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity<?> RecordNotFoundException(RecordNotFoundException ex){
        ErrorResponse errorResponse=new ErrorResponse(ex.getMessage());
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(errorResponse);
    }
    @ExceptionHandler(DuplicateRecordException.class)
    public ResponseEntity<?> DuplicateRecordException(DuplicateRecordException ex){
        ErrorResponse errorResponse=new ErrorResponse(ex.getMessage());
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(errorResponse);
    }
    @ExceptionHandler(RecordNotCorrectException.class)
    public ResponseEntity<?> DuplicateRecordException(RecordNotCorrectException ex){
        ErrorResponse errorResponse=new ErrorResponse(ex.getMessage());
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(errorResponse);
    }
    @ExceptionHandler
    public ResponseEntity<?> handelException(Exception ex){
        ErrorResponse errorResponse=new ErrorResponse(ex.getMessage());
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(errorResponse);
    }
//@ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public Map<String,String>MethodArgumentNotValidException(MethodArgumentNotValidException ex){
//        Map<String,String> errorMap=new HashMap<>();
//        ex.getBindingResult().getFieldErrors().forEach(error->{
//            errorMap.put(error.getField(),error.getDefaultMessage());
//        });
//        return errorMap;
//
//    }

}
