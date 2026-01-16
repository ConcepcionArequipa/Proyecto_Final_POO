package com.instituto.gestionestudiantes.controller;

import com.instituto.gestionestudiantes.entity.Estudiante;
import com.instituto.gestionestudiantes.service.EstudianteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteController {

    @Autowired
    private EstudianteService estudianteService;

    // GET: http://localhost:8080/api/estudiantes
    @GetMapping
    public List<Estudiante> listar() {
        return estudianteService.listarEstudiantes();
    }

    // PUT: http://localhost:8080/api/estudiantes/1
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Long id, @Valid @RequestBody Estudiante estudiante) {
        try {
            Estudiante actualizado = estudianteService.actualizar(id, estudiante);
            return ResponseEntity.ok(actualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}