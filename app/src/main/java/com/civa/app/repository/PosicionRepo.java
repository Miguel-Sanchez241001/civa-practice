package com.civa.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.civa.app.models.Posicion;
import com.civa.app.models.enums.PosicionType;

 @Repository
public interface PosicionRepo  extends JpaRepository<Posicion, Long> {
    public Optional<Posicion> findByPosicionType(PosicionType posicionType);
}
 