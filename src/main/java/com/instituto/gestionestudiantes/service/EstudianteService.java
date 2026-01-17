package com.instituto.gestionestudiantes.service;
import com.instituto.gestionestudiantes.entity.Estudiante;
import com.instituto.gestionestudiantes.exception.RecursoNoEncontradoException;
import com.instituto.gestionestudiantes.repository.EstudianteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class EstudianteService {
    @Autowired //Inyeccion
    private EstudianteRepository estudianteRepository;

    // Listar todos
    public List<Estudiante> history() {
        return estudianteRepository.findAll();
    }

    //2. Obtener por id

    public Estudiante findById(Long id) {
        return estudianteRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException(id));
    }

    //3. Crear un nuevo registro

    public Estudiante crearEstudiante(Estudiante estudiante) {

        //Validacion de la cedula
        if (estudianteRepository.existsByCedula(estudiante.getCedula())) {
            throw new RuntimeException("La cedula "+estudiante.getCedula()+" ya esta registrada");
        }

        //Verificar el email

        if (estudianteRepository.existsByEmail(estudiante.getEmail())) {
            throw new RuntimeException("El email "+estudiante.getEmail()+" ya esta registrado");
        }

        // Formatear nombre y apellido (opcional pero útil)
        estudiante.setNombre(estudiante.getNombre().trim().toUpperCase());
        estudiante.setApellido(estudiante.getApellido().trim().toUpperCase());
        return estudianteRepository.save(estudiante);
    }

    // Actualizar
    public Estudiante actualizer(Long id,@Valid Estudiante estudianteDetalle) {
        return estudianteRepository.findById(id).map(estudiante ->  {
            estudiante.setNombre(estudianteDetalle.getNombre());
            estudiante.setApellido(estudianteDetalle.getApellido());
            estudiante.setEmail(estudianteDetalle.getEmail());
            estudiante.setCedula(estudianteDetalle.getCedula());
            estudiante.setEdad(estudianteDetalle.getEdad());
            estudiante.setSemestre(estudianteDetalle.getSemestre());
            estudiante.setCarrera(estudianteDetalle.getCarrera());

            return estudianteRepository.save(estudiante);

        }).orElseThrow(() -> new RuntimeException("Estudiante no encontrado con id: " + id));
    }

    //Eliminar

    public void eliminar(Long id) {
        //Verifar si ya existe el id
        if (!estudianteRepository.existsById(id)) {
            throw new RecursoNoEncontradoException(id);
        }
        estudianteRepository.deleteById(id);
    }


}