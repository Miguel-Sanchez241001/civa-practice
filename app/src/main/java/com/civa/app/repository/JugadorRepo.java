package com.civa.app.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.civa.app.models.Jugador;

@Repository
public interface JugadorRepo extends JpaRepository<Jugador, Long> {
    
}
 