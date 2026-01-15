package com.instituto.gestionestudiantes.entity;

import jakarta.persistence.*; //Mapea objetos de java a tabla de bd
import jakarta.validation.constraints.*; //Para validar datos antes de guardarlos en la bd

@Entity //Marca la clase como una tabla de bd

@Table(name = "estudiantes") //Define el nombre de la tabla
public class Estudiante {

    // 1. Id

    @Id
    //Genera valores automaticos
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT en mysql
    private Long id; //PRIMARY KEY AUTO_INCREMENT mysql

    //Valida que el campo no este vacio
    @NotBlank(message = "El nombre es obligatorio")

    //Valida la longitud
    @Size(min = 2, max = 50, message = "El nombre debe tener entre 2 y 50 caracteres")

    //Nombre de la columna, nullable no permite que se ingrese valores vacios, length el tamaño o longitud
    @Column(name = "nombre",nullable = false,length = 50)

    private String nombre;

    @NotBlank(message = "El apellido es obligatorio")

    @Size(min = 2,max = 50, message = "El apellido debe tener entre 2 y 50 caracteres")

    @Column(name = "apellido",nullable = false,length = 50)

    private String apellido;

    //Cedula de identidad
    @NotBlank(message = "La cedula de identidad es obligatoria")
    @Size(min = 10,max = 10,message = "La cedula debe tener 10 digitos")
    @Column(name = "cedula",unique = true,nullable = false,length = 10)
    private String cedula;

    //Edad

    @NotNull(message = "La edad es obligatoria")
    @Min(value = 16,message = "La edad minima es de 16 años")
    @Max(value = 90, message = "La edad maxima es de 90 años")
    @Column(name = "edad",nullable = false)
    private Integer edad;

    //Email
    @NotBlank(message = "El email es obligatorio")
    @Email(message = "El email debe ser valido")
    @Column(name = "email",nullable = false,unique = true,length = 100)
    private String email;

    //Carrera
    @NotBlank(message = "La carrera es obligatoria")
    @Size(min = 5, max = 100,message = "El nombre de la carrera debe tener entre 5 y 100 caracteres")
    @Column(name = "carrera",nullable = false,length = 100)
    private String carrera;

    //Semestre
    @NotNull(message = "El semestre es obligatorio")
    @Min(value = 1,message = "El semestre minimo es 1")
    @Max(value = 10,message = "El semestre maximo es 10")
    @Column(name = "semestre",nullable = false)
    private Integer semestre;

    //Constructor vacio para JPA

    public Estudiante() {}

    public Estudiante(String nombre, String apellido, String cedula, Integer edad, String email, String carrera, Integer semestre) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.edad = edad;
        this.email = email;
        this.carrera = carrera;
        this.semestre = semestre;
    }

    //Getters y setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public Integer getSemestre() {
        return semestre;
    }

    public void setSemestre(Integer semestre) {
        this.semestre = semestre;
    }
}
