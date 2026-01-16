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
    public List<Estudiante> history() {
        return estudianteService.history();
    }

    // PUT: http://localhost:8080/api/estudiantes/1
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizer(@PathVariable Long id, @Valid @RequestBody Estudiante estudiante) {
        try {
            Estudiante actualize = estudianteService.actualizer(id, estudiante);
            return ResponseEntity.ok(actualize);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}