package br.dev.guisleri.treinoapispring.controller;

import br.dev.guisleri.treinoapispring.dto.ErrorDTO;
import br.dev.guisleri.treinoapispring.exception.AlunoNotFoundException;
import br.dev.guisleri.treinoapispring.exception.ExercicioNotFoundException;
import br.dev.guisleri.treinoapispring.exception.TreinoExercicioNotFoundException;
import br.dev.guisleri.treinoapispring.exception.TreinoNotFoundException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AlunoNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleAlunoNotFound(AlunoNotFoundException ex) {
        return ResponseEntity
                .status(404)
                .body(new ErrorDTO(ex.getMessage()));
    }

    @ExceptionHandler(TreinoNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleTreinoNotFound(TreinoNotFoundException ex) {
        return ResponseEntity
                .status(404)
                .body(new ErrorDTO(ex.getMessage()));
    }

    @ExceptionHandler(ExercicioNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleExercicioNotFound(ExercicioNotFoundException ex) {
        return ResponseEntity
                .status(404)
                .body(new ErrorDTO(ex.getMessage()));
    }

    @ExceptionHandler(TreinoExercicioNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleTreinoExercicioNotFound(TreinoExercicioNotFoundException ex) {
        return ResponseEntity
                .status(404)
                .body(new ErrorDTO(ex.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDTO> handleValidation(MethodArgumentNotValidException ex) {
        String mensagem = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .findFirst()
                .orElse("Erro de validação");
        return ResponseEntity.badRequest().body(new ErrorDTO(mensagem));
    }
}
