package com.civa.app.models;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "jugador")
public class Jugador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)  // El id se incluye en las respuestas, no en las solicitudes
    private Long id;

    @Column(name = "nombres")
    private String nombres;

    @Column(name = "apellidos")
    private String apellidos;


    @Column(name = "edad")
    private LocalDate fechaNacimiento;

    @ManyToOne 
    @JoinColumn(name =" position_id")
    //@JsonProperty(access = JsonProperty.Access.READ_ONLY)  // El id se incluye en las respuestas, no en las solicitudes
    private Posicion posicion;
    
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)  // El id se incluye en las respuestas, no en las solicitudes
    @OneToMany(mappedBy = "jugador", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Caracteristica> caracteristicas  ;



    // Getters, setters, constructores y otros métodos
}