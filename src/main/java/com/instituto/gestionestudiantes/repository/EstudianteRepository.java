package com.instituto.gestionestudiantes.repository;

import com.instituto.gestionestudiantes.entity.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

// Spring Data JPA crea automáticamente métodos CRUD básicos del documento

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {

}
