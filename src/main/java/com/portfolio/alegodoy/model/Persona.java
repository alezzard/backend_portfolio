package com.portfolio.alegodoy.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Getter @Setter
@Entity
public class Persona {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull @Size(min = 3, max = 50,message = "no cumple con la longitud")
    private String nombre;

    @NotNull @Size(min = 3, max = 50,message = "no cumple con la longitud")
    private String apellido;

    @NotNull @Size(min = 3, max = 50,message = "no cumple con la longitud")
    private String titulo;

    @NotNull @Size(min = 3, max = 150,message = "no cumple con la longitud")
    private String descripcion;

    @NotNull @Size(min = 3, max = 250,message = "no cumple con la longitud")
    private String imgPerfil;

    public Persona() {
    }

    public Persona(String nombre, String apellido, String titulo, String descripcion, String imgPerfil) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.imgPerfil = imgPerfil;
    }
}
