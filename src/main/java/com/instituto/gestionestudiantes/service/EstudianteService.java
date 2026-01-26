package com.instituto.gestionestudiantes.service;
import com.instituto.gestionestudiantes.entity.Estudiante;
import com.instituto.gestionestudiantes.exception.RecursoNoEncontradoException;
import com.instituto.gestionestudiantes.repository.EstudianteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class EstudianteService {
    @Autowired //Inyeccion
    private final EstudianteRepository estudianteRepository;

    public EstudianteService(EstudianteRepository estudianteRepository) {
        this.estudianteRepository = estudianteRepository;
    }

    // Listar todos
    public List<Estudiante> listarEstudiantes() {
        return estudianteRepository.findAll();
    }

    //2. Obtener por id

    public Estudiante findById(Long id) {
        return estudianteRepository.findById(id).orElseThrow(() -> new RecursoNoEncontradoException(id));
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

        // Formatear nombre y apellido
        estudiante.setNombre(estudiante.getNombre().trim().toUpperCase());
        estudiante.setApellido(estudiante.getApellido().trim().toUpperCase());
        return estudianteRepository.save(estudiante);
    }

    // Actualizar
    public Estudiante actualizar(Long id, Estudiante estudianteActualizado) {
        //Verificar que existe
        Estudiante estudianteExistente = findById(id);

        //Verificar si la cedula cambio y si ya existe

        if (!estudianteExistente.getCedula().equals(estudianteActualizado.getCedula()) && estudianteRepository.existsByCedula(estudianteActualizado.getCedula())) {
            throw new RuntimeException("Cédula "+estudianteActualizado.getCedula()+" ya esta registrada");
        }

        //Verificar si el email cambio y si ya existe

        if (!estudianteExistente.getEmail().equals(estudianteActualizado.getEmail()) && estudianteRepository.existsByEmail(estudianteActualizado.getEmail())) {
            throw new RuntimeException("Email "+estudianteActualizado.getEmail()+" ya esta registrado");
        }

        estudianteExistente.setNombre(estudianteActualizado.getNombre());
        estudianteExistente.setApellido(estudianteActualizado.getApellido());
        estudianteExistente.setCedula(estudianteActualizado.getCedula());
        estudianteExistente.setEdad(estudianteActualizado.getEdad());
        estudianteExistente.setEmail(estudianteActualizado.getEmail());
        estudianteExistente.setSemestre(estudianteActualizado.getSemestre());
        estudianteExistente.setCarrera(estudianteActualizado.getCarrera());

        return estudianteRepository.save(estudianteExistente);
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