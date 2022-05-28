package com.portfolio.alegodoy.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Getter @Setter
@Entity
public class Habilidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 250, message = "no cumple con la longitud")
    private String imgLogo;

    @NotNull @Column(columnDefinition = "INT")
    @Size(min = 1, max = 3, message = "no cumple con la longitud")
    private String porcentaje;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idPersona", nullable = false)
    private Persona persona;

    public Habilidad() {
    }

    public Habilidad(String imgLogo, String porcentaje, Persona persona) {
        this.imgLogo = imgLogo;
        this.porcentaje = porcentaje;
        this.persona = persona;
    }
}