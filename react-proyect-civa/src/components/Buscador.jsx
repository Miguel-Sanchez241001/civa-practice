import React, { useState } from 'react'

import "../assets/css/BodyStyle.css"

function Buscador() {

const [idbuscar,setIdBuscar] = useState(0)

const [dataJugador,setDataJugador] = useState(null)

const handChangeId = (e)=>{
    setIdBuscar(e.target.value)
}

const handClinkId = (e)=>{
    const fetchData = async () => {
        try {
          const response = await fetch('http://localhost:8080/futbolista/'+idbuscar);
          const data = await response.json();
          setDataJugador(data);
        } catch (error) {
          console.error('Error al obtener los datos:', error);
        }
      };
      fetchData();
      let usuario = {
        nombre : dataJugador.nombres,
        apellido :  dataJugador.apellidos,
        nacimiento :  dataJugador.fechaNacimiento,
        posicion :  dataJugador.posicion.posicionType
      };
    alert( JSON.stringify(usuario));
}
    return (
    <div className=' buscador mt-25'>
        <input type='number' value={idbuscar} onChange={handChangeId}></input>
        <button type="button" onClick={handClinkId} className=" btn-buscar btn btn-primary" >Buscar Jugador por Id</button>

    </div>
  )
}

export default Buscador