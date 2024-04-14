package com.civa.app.models;

import com.civa.app.models.enums.PosicionType;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "posicion")
public class Posicion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)  // El id se incluye en las respuestas, no en las solicitudes
    private Long id;

   


    @Enumerated(EnumType.STRING)
    @Column(name = "puesto")
     private PosicionType posicionType;

      // Constructor que acepta solo el tipo de posición
    public Posicion(PosicionType posicionType) {
        this.posicionType = posicionType;
    }
}
