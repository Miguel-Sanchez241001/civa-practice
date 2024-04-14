package com.civa.app.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "caracteristica")
public class Caracteristica {

     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)  // El id se incluye en las respuestas, no en las solicitudes
    private Long id;

   @Column(name = "nombreCaracteristica")
    private String tag;

    @Column(name = "valorCaracteristicas")
    private String valor;
    
    @ManyToOne
    @JoinColumn(name = "jugador_id")
    @JsonIgnore
    private Jugador jugador;

}
