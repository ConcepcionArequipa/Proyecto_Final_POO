import axios from 'axios';

// Esta es la URL de tu API de Spring Boot
const API_URL = "http://localhost:8080/api/estudiantes";

export const getEstudiantes = async () => {
    return await axios.get(API_URL);
};