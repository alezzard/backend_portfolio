package com.portfolio.alegodoy.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Getter @Setter
@Entity
public class Proyecto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 3, max = 45, message = "no cumple con la longitud")
    private String nombre;

    @NotNull
    @Size(min = 3, max = 25, message = "no cumple con la longitud")
    private String periodo;

    @NotNull
    @Size(min = 3, max = 350, message = "no cumple con la longitud")
    private String descripcion;

    @NotNull
    @Size(min = 3, max = 250, message = "no cumple con la longitud")
    private String imgProyecto;

    @NotNull
    @Size(min = 3, max = 250, message = "no cumple con la longitud")
    private String link;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idPersona", nullable = false)
    private Persona persona;

    public Proyecto() {
    }

    public Proyecto(String nombre, String periodo, String descripcion, String imgProyecto, String link, Persona persona){
        this.nombre = nombre;
        this.periodo = periodo;
        this.descripcion = descripcion;
        this.imgProyecto = imgProyecto;
        this.link = link;
        this.persona = persona;
    }
}
