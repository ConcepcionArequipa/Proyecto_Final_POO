import { useEffect, useState } from 'react'
import { getEstudiantes } from './api'

function App() {
  const [estudiantes, setEstudiantes] = useState([]);
  const fechaActual = new Date().toLocaleDateString();

  useEffect(() => {
    getEstudiantes()
      .then(response => { setEstudiantes(response.data); })
      .catch(error => console.error("Error:", error));
  }, []);

  return (
    <div className="container my-5 p-5 bg-white shadow-lg border-top border-primary border-5 rounded-3">
      {/* Encabezado Institucional */}
      <div className="d-flex justify-content-between align-items-center mb-4 pb-3 border-bottom">
        <div>
          <h1 className="h2 fw-bold text-dark mb-0">REPORTE DE ESTUDIANTES</h1>
          <p className="text-muted text-uppercase small tracking-widest">Registro Académico Oficial</p>
        </div>
        <div className="text-end">
          <p className="mb-0 fw-bold">Fecha: <span className="fw-normal">{fechaActual}</span></p>
          <p className="mb-0 fw-bold">Total: <span className="badge bg-dark">{estudiantes.length}</span></p>
        </div>
      </div>

      {/* Tabla con Estilo Profesional */}
      <div className="table-responsive">
        <table className="table table-hover align-middle border">
          <thead className="table-dark text-center">
            <tr>
              <th style={{width: '10%'}}>ID</th>
              <th style={{width: '20%'}}>Nombre</th>
              <th style={{width: '20%'}}>Apellido</th>
              <th style={{width: '40%'}}>Carrera</th>
              <th style={{width: '10%'}}>Sem.</th>
            </tr>
          </thead>
          <tbody className="text-uppercase" style={{fontSize: '0.9rem'}}>
            {estudiantes.map((est, index) => (
              <tr key={est.id || index}>
                <td className="text-center fw-bold text-muted border-end">{String(est.id).padStart(3, '0')}</td>
                <td className="ps-3">{est.nombre}</td>
                <td>{est.apellido}</td>
                <td className="small text-secondary">{est.carrera}</td>
                <td className="text-center fw-bold text-primary bg-light">{est.semestre}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>

      {/* Firma y Sello Digital */}
      <div className="mt-5 d-flex justify-content-between align-items-end">
        <div className="text-muted small italic">
          <p className="mb-0">*** Reporte generado automáticamente ***</p>
          <p>ID de Verificación: {Math.random().toString(36).substr(2, 9).toUpperCase()}</p>
        </div>
        <button onClick={() => window.print()} className="btn btn-outline-secondary d-print-none">
          🖨️ Imprimir Reporte
        </button>
      </div>
    </div>
  )
}

export default App