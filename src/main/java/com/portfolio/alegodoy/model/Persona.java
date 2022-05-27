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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 3, max = 45, message = "no cumple con la longitud")
    private String nombre;

    @NotNull
    @Size(min = 3, max = 45, message = "no cumple con la longitud")
    private String apellido;

    @NotNull
    @Size(max = 45, message = "no cumple con la longitud")
    private String titulo;

    @NotNull
    @Size(max = 150, message = "no cumple con la longitud")
    private String descripcion;

    @NotNull
    @Size(max = 250, message = "no cumple con la longitud")
    private String imgPerfil;

    @Size(max = 150, message = "no cumple con la longitud")
    private String linkedin;

    @Size(max = 150, message = "no cumple con la longitud")
    private String instagram;

    @Size(max = 150, message = "no cumple con la longitud")
    private String github;

    @NotNull
    @Size(max = 250, message = "no cumple con la longitud")
    private String imgBanner;


    public Persona() {
    }

    public Persona(String nombre, String apellido, String titulo, String descripcion, String imgPerfil,
                   String linkedin, String instagram, String github, String imgBanner) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.imgPerfil = imgPerfil;
        this.linkedin = linkedin;
        this.instagram = instagram;
        this.github = github;
        this.imgBanner = imgBanner;
    }
}
