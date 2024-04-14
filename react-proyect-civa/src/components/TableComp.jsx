 
import React, { useEffect, useState } from 'react';
import { Table, Pagination } from 'react-bootstrap';

 function TableComp({ actualizar }) {

  
  const [data, setData] = useState([]);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await fetch('http://localhost:8080/futbolista');
        const data = await response.json();
        setData(data);
      } catch (error) {
        console.error('Error al obtener los datos:', error);
      }
    };

    fetchData();
  }, [actualizar]);

   
  const [currentPage, setCurrentPage] = useState(1);
  const totalItems = data.length;
  const totalPages = Math.ceil(totalItems / 10);

  const startIndex = (currentPage - 1) * 10;
  const endIndex = startIndex + 10;
  const currentItems = data.slice(startIndex, endIndex);

  const paginationItems = [];
  for (let number = 1; number <= totalPages; number++) {
    paginationItems.push(
      <Pagination.Item key={number} active={number === currentPage} onClick={() => setCurrentPage(number)}>
        {number}
      </Pagination.Item>
    );
  }


  return (
    <>

      <Table  striped bordered hover>
        <thead>
          <tr>
            <th scope="col">#</th>
            <th scope="col">Nombre</th>
            <th scope="col">Apellido</th>
            <th scope="col">Fecha Nacimiento</th>
            <th scope="col">Posicion</th>
          </tr>
        </thead>
        {/* <tbody>
          {data?.map((jugador) => (
            <tr key={jugador.id}>
              <th scope="row">{jugador.id}</th>
              <td>{jugador.nombres}</td>
              <td>{jugador.apellidos}</td>
              <td>{jugador.fechaNacimiento}</td>
              <td>{jugador.posicion.posicionType}</td>
            </tr>
          ))}
        </tbody> */}
         <tbody>
          {currentItems.map((jugador, index) => (
            <tr key={index}>
              <th scope="row">{jugador.id}</th>
              <td>{jugador.nombres}</td>
              <td>{jugador.apellidos}</td>
              <td>{jugador.fechaNacimiento}</td>
              <td>{jugador.posicion.posicionType}</td>
            </tr>
          ))}
        </tbody>
       
      </Table>
      <Pagination>{paginationItems}</Pagination>


    </>
  );
}

export default TableComp;