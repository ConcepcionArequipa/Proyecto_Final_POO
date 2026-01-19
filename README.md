# API REST – Gestión de Estudiantes

Proyecto final de la asignatura **Desarrollo Backend con Spring Boot**, correspondiente a la carrera de **Tecnología Superior en Desarrollo de Software**.

---

## Descripción del Proyecto

Este proyecto consiste en el desarrollo de una **API REST** para la gestión de estudiantes de un instituto, permitiendo realizar operaciones **CRUD** (Crear, Leer, Actualizar y Eliminar).

La API valida los datos de entrada, maneja errores de forma profesional y devuelve respuestas claras al cliente que consuma el servicio.

---

## Tecnologías Utilizadas

* Java 17
* Spring Boot
* Spring Data JPA
* MySQL
* Maven
* Postman
* Swagger OpenAPI
* React (Frontend separado)

---

## Estructura del Proyecto

```
backend-gestion-estudiantes/
├── controller
├── service
├── repository
├── entity
├── dto
├── exception
└── resources
    ├── application.properties
    └── data.sql
```

Arquitectura en capas:
**Controller → Service → Repository**

---

## Entidad Estudiante

Atributos principales:

| Campo    | Tipo    | Validaciones              |
| -------- | ------- | ------------------------- |
| id       | Long    | @Id, @GeneratedValue      |
| nombre   | String  | @NotBlank, @Size          |
| apellido | String  | @NotBlank, @Size          |
| cedula   | String  | @NotBlank, @Size, unique  |
| email    | String  | @NotBlank, @Email, unique |
| edad     | Integer | @Min, @Max                |
| carrera  | String  | @NotBlank                 |
| semestre | Integer | @Min, @Max                |

---

## Funcionalidades (Endpoints)

| Método | Endpoint                | Descripción                  |
| ------ | ----------------------- | ---------------------------- |
| GET    | `/api/estudiantes`      | Listar todos los estudiantes |
| GET    | `/api/estudiantes/{id}` | Obtener estudiante por ID    |
| POST   | `/api/estudiantes`      | Crear nuevo estudiante       |
| PUT    | `/api/estudiantes/{id}` | Actualizar estudiante        |
| DELETE | `/api/estudiantes/{id}` | Eliminar estudiante          |

---

## Validaciones Implementadas

* Campos obligatorios con `@NotBlank` y `@NotNull`
* Longitud de texto con `@Size`
* Rangos numéricos con `@Min` y `@Max`
* Validación de correos electrónicos con `@Email`
* Control de duplicados (cédula y email)

---

## Manejo de Errores

* Excepción personalizada para recursos no encontrados
* Manejo global de errores con `@ControllerAdvice`
* Códigos HTTP utilizados:

  * 200 OK
  * 201 Created
  * 400 Bad Request
  * 404 Not Found
  * 500 Internal Server Error

---

##  Base de Datos

* Motor: **MySQL**
* Configuración en `application.properties`
* Datos de prueba cargados automáticamente con `data.sql`


---

## Documentación con Swagger

La API está documentada con Swagger.

Acceso:

```
http://localhost:8080/swagger-ui/index.html
```

Desde Swagger es posible probar todos los endpoints.

---

## Ejecución del Proyecto

### Backend

1. Clonar el repositorio
2. Configurar credenciales de MySQL en `application.properties`
3. Ejecutar el proyecto desde el IDE o con:

   ```
   mvn spring-boot:run
   ```

### Frontend (React)

1. Ingresar a la carpeta del frontend
2. Instalar dependencias:

   ```
   npm install
   ```
3. Ejecutar:

   ```
   npm start
   ```

---

## Autores

Proyecto desarrollado por:

* **Josue Patiño**
* **Concepción Arequipa**

---

## 🎥 Evidencias

* Pruebas de endpoints realizadas en Postman(docs)
* Video de funcionamiento y explicación del proyecto
  link:


---
