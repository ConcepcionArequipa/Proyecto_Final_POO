package com.instituto.gestionestudiantes.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.LinkedHashMap; //Para un orden correcto
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
    // Para recursos no encontrados 404
    // En especifico, cuando no encuentra estudiante por ID
    @ExceptionHandler(RecursoNoEncontradoException.class)
    public ResponseEntity<Object>manejarRecursoNoEncontrado(RecursoNoEncontradoException ex) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status",404);
        body.put("error","Not found" );
        body.put("message",ex.getMessage());

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    // La solicitud contiene errores o datos inválidos (400)
    // En especifico, cuando fallan validaciones (@Valid)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object>manejarMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status",400);
        body.put("error","Bad Request" );
        body.put("message","Error de validacion");

        //Detalles de cada error de campo
        Map<String, String> errors = new LinkedHashMap<>();
        ex.getBindingResult().getFieldErrors().forEach((error) -> {
            errors.put(error.getField(), error.getDefaultMessage());
        });
        body.put("errors",errors);
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);

    }

    //Para cualquier otro error (500)

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object>manejarExceptionGeneral(Exception ex) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status",500);
        body.put("error","Internal Server Error" );
        body.put("message","Ha ocurrido un error inesperado");

        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
