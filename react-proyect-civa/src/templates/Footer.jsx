import React from 'react'

function Footer() {
  return (
   
<footer className="bg-dark text-white py-5">
  <div className="container">
    <div className="row">
      <div className="col-md-4">
        <h5>Acerca de</h5>
        <p>Prueba tecnica practicante Desarrollador empresa Civa</p>
      </div>
      <div className="col-md-4">
        <h5>Enlaces</h5>
        <ul className="list-unstyled">
          <li><a href="https://github.com/Miguel-Sanchez241001" target='_blank' className="text-white">Github</a></li>
          <li><a href="https://www.linkedin.com/in/miguelsanchezdev/"  target='_blank'className="text-white">Linkedin</a></li>
         </ul>
      </div>
      <div className="col-md-4">
        <h5>Contacto</h5>
        <ul className="list-unstyled">
          <li><i className="fas fa-map-marker-alt me-2"></i>Lima, Peru</li>
          <li><i className="fas fa-envelope me-2"></i>mivansansanchez@gmail.com</li>
          <li><i className="fas fa-phone me-2"></i>993 652 654</li>
        </ul>
      </div>
    </div>
    <hr className="mb-4"/>
    <div className="row">
      <div className="col-md-12 text-center">
        <p>&copy; 2024 Civa. Todos los derechos reservados.</p>
      </div>
    </div>
  </div>
</footer>
  )
}

export default Footer