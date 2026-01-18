package com.instituto.gestionestudiantes.repository;

import com.instituto.gestionestudiantes.entity.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



// Spring Data JPA crea automáticamente métodos CRUD básicos del documento

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {
    boolean existsByCedula(String cedula);
    boolean existsByEmail(String email);
}
