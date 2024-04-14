import React, { useState } from 'react'
import { UseHook } from '../usehook/UseHook'
import Buscador from './Buscador';


function FormComp({ agregarDato }) {
  const { data } = UseHook("http://localhost:8080/futbolista/posicion");
  const [selectedPosition, setSelectedPosition] = useState(''); // Agrega un estado para la posición seleccionada
  const [nombres, setNombres] = useState('');
  const [apellidos, setApellidos] = useState('');
   const [inputDate, setInputDate] = useState(''); // Agrega un estado para la posición seleccionada
   const [formData, setFormData] = useState({
    nombres: '',
    apellidos: '',
    inputDate: '',
    selectedPosition: '',
  });



  const handleNombresChange = (e) => {
    setNombres(e.target.value);
  };
  
  const handleApellidosChange = (e) => {
    setApellidos(e.target.value);
  };

  const handlePositionChange = (e) => {
    setSelectedPosition(e.target.value); // Actualiza el estado con la posición seleccionada
  };

 
  const handleDateChange = (e) => {
    setInputDate(e.target.value); // Actualiza el estado con la posición seleccionada
  };


  const handleSubmit = (e) => {
    e.preventDefault();
        const nuevosDatos = {
      nombres,
      apellidos,
      fechaNacimiento: inputDate,
      posicion: {
        posicionType: selectedPosition,
      },
    };
    agregarDato(nuevosDatos);
    setApellidos('');
    setNombres('');
    setSelectedPosition('');
    setInputDate('');
      
     
  };









  return (
    <>
    <h1> Jugador</h1>
       <form onSubmit={handleSubmit}>
    <div className="mb-3">
  <label htmlFor="exampleInputNombre1" className="form-label">
    Nombre
  </label>
  <input
    type="text"
    className="form-control"
    id="exampleInputNombre1"
    aria-describedby="NombreHelp"
    value={nombres}
    onChange={handleNombresChange}
  />
</div>
<div className="mb-3">
  <label htmlFor="exampleInputApellidos1" className="form-label">
    Apellidos
  </label>
  <input
    type="text"
    className="form-control"
    id="exampleInputApellidos1"
    value={apellidos}
    onChange={handleApellidosChange}
  />
</div>

      <div className="mb-3">

    <label htmlFor="fecha" className="form-label">Fecha Nacimiento:</label>
    <input 
    type="date"
     className="form-control" 
     id="fecha" 
     name="fecha" 
     value={inputDate}  
     onChange={handleDateChange}  />
    </div>
      <div className="mb-3">
        <select className="form-select" aria-label="Default select example" value={selectedPosition} onChange={handlePositionChange}>
          <option value="">Selecciona posición</option>
          {data?.map((posicion) => (
            <option key={posicion.id} value={posicion.posicionType}>{posicion.posicionType}</option>
          ))}
        </select>
      </div>
      <button className="btn btn-primary">Registrar</button>
    </form>
    <Buscador/>
    </>
 
  )
}

export default FormComp