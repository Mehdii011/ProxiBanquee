package com.hamilton.proxibanque.exception;

import com.hamilton.proxibanque.responses.ErrorMessage;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
    public class AppException {


    @ExceptionHandler(value = CompteIntrouvable.class)
    public ResponseEntity<Object> HandlerCompteException(CompteIntrouvable ex, WebRequest webRequest){

        ErrorMessage errorMessage=new ErrorMessage(new Date(),ex.getMessage());

        return new ResponseEntity<>(errorMessage,new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);

    }
    @ExceptionHandler(value = DebitImpossibleException.class)
    public ResponseEntity<Object> HandlerDebiterCompteException(DebitImpossibleException ex, WebRequest webRequest){

        ErrorMessage errorMessage=new ErrorMessage(new Date(),ex.getMessage());

        return new ResponseEntity<>(errorMessage,new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);

    }
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Object> HandlerOtherException(Exception ex, WebRequest webRequest){

        ErrorMessage errorMessage=new ErrorMessage(new Date(),ex.getMessage());

        return new ResponseEntity<>(errorMessage,new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);

    }
   @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<Object> MethodeArgumentNotValid(MethodArgumentNotValidException ex, WebRequest webRequest){

        Map<String,String> errors=new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(),error.getDefaultMessage()));
        return new ResponseEntity<>(errors,new HttpHeaders(), HttpStatus.BAD_REQUEST);

    }

}
