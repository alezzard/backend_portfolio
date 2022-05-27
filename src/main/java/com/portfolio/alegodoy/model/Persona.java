package com.portfolio.alegodoy.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Getter @Setter
@Entity
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPersona;

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

    //listas de relaciones
    @OneToMany(mappedBy = "persona",fetch = FetchType.LAZY)
    private List<Experiencia> listaExperiencias;

    @OneToMany(mappedBy = "persona",fetch = FetchType.LAZY)
    private List<Habilidad> listaHabilidades;

    @OneToMany(mappedBy = "persona",fetch = FetchType.LAZY)
    private List<Proyecto> listaProyectos;

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
