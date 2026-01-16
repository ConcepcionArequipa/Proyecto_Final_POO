package com.instituto.gestionestudiantes;

import com.instituto.gestionestudiantes.entity.Estudiante;
import com.instituto.gestionestudiantes.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.util.List;

@SpringBootApplication
public class GestionEstudiantesApplication {
    @Autowired
    private EstudianteRepository estudianteRepository;

    //Listar todos
    public List<Estudiante> listarEstudiantes() {
        return estudianteRepository.findAll();
    }

    //Actualizar
    public Estudiante actualizarEstudiante(Long id,Estudiante EstudianteDetalle) {
        return estudianteRepository.findById(id).map(estudiante ->  {
            estudiante.setId(EstudianteDetalle.getId());
            estudiante.setNombre(EstudianteDetalle.getNombre());
            estudiante.setApellido(EstudianteDetalle.getApellido());
            estudiante.setEmail(EstudianteDetalle.getEmail());
            estudiante.setCedula(EstudianteDetalle.getCedula());
            estudiante.setEdad(EstudianteDetalle.getEdad());
            estudiante.setSemestre(EstudianteDetalle.getSemestre());
            estudiante.setCarrera(EstudianteDetalle.getCarrera());

            return estudianteRepository.save(estudiante);

        }).orElseThrow(() -> new RuntimeException("Estudiante no encontrado con id : "+EstudianteDetalle.getId()));
    }


    public static void main(String[] args) {
        SpringApplication.run(GestionEstudiantesApplication.class, args);
    }

}
