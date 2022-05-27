package com.portfolio.alegodoy.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Getter @Setter
@Entity
public class Experiencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 3, max = 45, message = "no cumple con la longitud")
    private String titulo;

    @NotNull
    @Size(min = 3, max = 25, message = "no cumple con la longitud")
    private String periodo;

    @NotNull
    @Size(min = 3, max = 250, message = "no cumple con la longitud")
    private String descripcion;

    @Size(min = 3, max = 250, message = "no cumple con la longitud")
    private String imgLogo;

    @NotNull
    @Column(columnDefinition = "TINYINT(1)")
    private boolean tipo;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idPersona", nullable = false)
    private Persona persona;

    public Experiencia() {
    }

    public Experiencia(String titulo, String periodo, String descripcion, String imgLogo, boolean tipo) {
        this.titulo = titulo;
        this.periodo = periodo;
        this.descripcion = descripcion;
        this.imgLogo = imgLogo;
        this.tipo = tipo;
    }
}
