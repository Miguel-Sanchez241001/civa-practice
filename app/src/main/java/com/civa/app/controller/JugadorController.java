package com.civa.app.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
 import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.civa.app.models.Caracteristica;
import com.civa.app.models.Jugador;
import com.civa.app.models.Posicion;
import com.civa.app.repository.CaracteristicaRepo;
import com.civa.app.repository.JugadorRepo;
import com.civa.app.repository.PosicionRepo;

@RestController
@RequestMapping("/futbolista")
public class JugadorController {

    @Autowired
    private  JugadorRepo  JugadorRepo ;

    @Autowired
	private PosicionRepo repository;


    @Autowired
	private CaracteristicaRepo caracteristicaRepo; 

    @GetMapping
    public  ResponseEntity<List<Jugador>>  getAllJugadors() {
        return ResponseEntity.ok( JugadorRepo.findAll());
    }
    
    @GetMapping("/{id}")
    public  ResponseEntity<Jugador> deleteJugador(@PathVariable Long id) {
        return  ResponseEntity.ok(JugadorRepo .findById(id).get());
    }
   

    @PostMapping
    public ResponseEntity<Jugador> createJugador(@RequestBody Jugador Jugador) {
        Posicion posicion = repository.findByPosicionType(Jugador.getPosicion().getPosicionType()).get();
        Jugador.setPosicion(posicion);
        return   ResponseEntity.ok(JugadorRepo.save(Jugador));
    }

    @PostMapping("/{id}")
    public ResponseEntity<Jugador> darCaracteristicasJugador(@PathVariable Long id,
                                            @RequestBody Caracteristica caracteristica) {
        caracteristica.setJugador(JugadorRepo .findById(id).get() );
        caracteristicaRepo.save(caracteristica);                    
        return  ResponseEntity.ok(JugadorRepo .findById(id).get());
    }

    @GetMapping("/posicion")
    public  ResponseEntity<List<Posicion>>  getAllPosiciton() {
        return ResponseEntity.ok( repository.findAll());
    }
  
}