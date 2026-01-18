package com.instituto.gestionestudiantes.controller;

import com.instituto.gestionestudiantes.entity.Estudiante;
import com.instituto.gestionestudiantes.service.EstudianteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
        return estudianteService.listarEstudiantes();
    }

    //Obtener un registro por id

    @GetMapping ("/{id}")
    public ResponseEntity<Estudiante> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(estudianteService.findById(id));

    }

    // Crear un nuevo registro
    @PostMapping
    public ResponseEntity<Estudiante>crear(@Valid @RequestBody Estudiante estudiante) {
        Estudiante nuevo= estudianteService.crearEstudiante(estudiante);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }
 
    // PUT: http://localhost:8080/api/estudiantes/1
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Long id, @Valid @RequestBody Estudiante estudiante) {
        return ResponseEntity.ok(estudianteService.actualizar(id, estudiante));
    }

    //Eliminar un registro
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        estudianteService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

}