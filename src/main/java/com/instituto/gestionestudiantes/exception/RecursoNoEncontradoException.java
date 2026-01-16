package com.instituto.gestionestudiantes.exception;

public class RecursoNoEncontradoException extends RuntimeException {
    public RecursoNoEncontradoException(Long id) {
        super("Estudiante no encontrado con id: " + id);
    }

    // Para saber el error ORIGINAL que causo la excepción personalizada.
    public RecursoNoEncontradoException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }

    // Mensaje personalizado genérico
    public RecursoNoEncontradoException(String mensaje) {
        super(mensaje);
    }

}
