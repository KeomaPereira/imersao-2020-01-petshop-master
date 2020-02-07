package br.com.tt.petshop.api.handler;

import br.com.tt.petshop.api.exception.ClienteException;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class NomeInvalidoExceptionHandler {

    @ExceptionHandler(ClienteException.class)
    public ResponseEntity tratar (ClienteException e) {
        ApiError error = new ApiError(
                "nome_invalido",
                 e.getMessage(),
                LocalDateTime.now());

        return ResponseEntity.unprocessableEntity()
                .body(error);
    }
}
