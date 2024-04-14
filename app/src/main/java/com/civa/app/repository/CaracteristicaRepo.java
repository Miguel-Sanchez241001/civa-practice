package com.civa.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.civa.app.models.Caracteristica;
@Repository
public interface CaracteristicaRepo extends JpaRepository<Caracteristica, Long> {
    
}
 