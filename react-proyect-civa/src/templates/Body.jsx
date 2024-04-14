import React from 'react'
import '../assets/css/BodyStyle.css'
import FormComp from '../components/FormComp' 
import TableComp from '../components/TableComp'
import { useState } from 'react';
import { UseHook } from '../usehook/UseHook';

function Body() {
 

  const [datos, setDatos] = useState(false);
 
  const agregarDato = (nuevosDatos) => {

  
    fetch('http://localhost:8080/futbolista', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(nuevosDatos),
    })
      .then((response) => response.json())
      .then((data) => {
        console.log( data);
      })
      .catch((error) => {
        alert('Error:', error);
      }).finally(()=>{
         setDatos(!datos);
      } );


   };

  return (
    <div className='d-flex body' >
        <div className='col-4 me-1 p-3 bg-light border mb-2 shadow '   >
            <FormComp agregarDato={agregarDato} />
        </div>
        <div className="col-1 bg-transparent box-one" ></div>

        <div className='col-7 p-3 bg-light border mb-2 shadow '>
            <TableComp actualizar={datos}></TableComp>
        </div>
    </div>
  )
}

export default Body