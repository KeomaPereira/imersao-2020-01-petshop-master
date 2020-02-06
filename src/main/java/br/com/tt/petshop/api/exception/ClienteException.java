package br.com.tt.petshop.api.exception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.NoResultException;


public class ClienteException extends Exception{

        public ClienteException(String msg) {
            super(msg);
        }
    }
