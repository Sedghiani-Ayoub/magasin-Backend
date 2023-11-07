package com.funsot.magasin.exeptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.ConnectException;

@ControllerAdvice
public class GlobalExeptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<?> handleResourceNotFound(ResourceNotFound ex){
        return  ResponseEntity.ok().body(ex.getMessage());

    }
  //  @ExceptionHandler(ConnectException.class) {
   //     return ResponseEntity.ok().body(ex.getMessage());
   // }
}
