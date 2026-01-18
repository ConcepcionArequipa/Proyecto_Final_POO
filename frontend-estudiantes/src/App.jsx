import { useEffect, useState } from 'react'
import { getEstudiantes } from './api'

function App() {
  const [estudiantes, setEstudiantes] = useState([]);

  useEffect(() => {
    // Llamamos a la API cuando carga la página
    getEstudiantes()
      .then(response => {
        setEstudiantes(response.data);
      })
      .catch(error => console.error("Error conectando a la API:", error));
  }, []);

  return (
    <div style={{ padding: '20px' }}>
      <h1>Gestión de Estudiantes</h1>
      <table border="1">
        <thead>
          <tr>
            <th>Nombre</th>
            <th>Apellido</th>
            <th>Carrera</th>
            <th>Semestre</th>
          </tr>
        </thead>
        <tbody>
          {estudiantes.map((est) => (
            <tr key={est.id}>
              <td>{est.nombre}</td>
              <td>{est.apellido}</td>
              <td>{est.carrera}</td>
              <td>{est.semestre}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  )
}

export default App