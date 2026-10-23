package src;

import jakarta.validation.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@RestControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public org.springframework.http.ResponseEntity<Map<String, String>> tratarValidacao(
            MethodArgumentNotValidException exception
    ) {
        String message = exception.getBindingResult().getFieldErrors().stream()
                .map(error -> error.getDefaultMessage())
                .findFirst()
                .orElse("Dados inválidos.");
        return resposta(HttpStatus.BAD_REQUEST, message);
    }

    @ExceptionHandler({IllegalArgumentException.class, ConstraintViolationException.class,
            HttpMessageNotReadableException.class})
    public org.springframework.http.ResponseEntity<Map<String, String>> tratarRequisicao(Exception exception) {
        String message = exception instanceof IllegalArgumentException
                ? exception.getMessage()
                : "O corpo da requisição contém dados inválidos.";
        return resposta(HttpStatus.BAD_REQUEST, message);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public org.springframework.http.ResponseEntity<Map<String, String>> tratarDuplicidade() {
        return resposta(HttpStatus.CONFLICT,
                "Não foi possível salvar: CPF, RG, CNPJ, email ou login já cadastrado.");
    }

    @ExceptionHandler(ResponseStatusException.class)
    public org.springframework.http.ResponseEntity<Map<String, String>> tratarStatus(ResponseStatusException exception) {
        return resposta(HttpStatus.valueOf(exception.getStatusCode().value()), exception.getReason());
    }

    private org.springframework.http.ResponseEntity<Map<String, String>> resposta(HttpStatus status, String message) {
        return org.springframework.http.ResponseEntity.status(status).body(Map.of("erro", message));
    }
}
