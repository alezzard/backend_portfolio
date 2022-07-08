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
    @Size(min = 3, max = 90, message = "no cumple con la longitud")
    private String fullName;

    @NotNull
    @Size(max = 45, message = "no cumple con la longitud")
    private String titulo;

    @NotNull
    @Size(max = 350, message = "no cumple con la longitud")
    private String descripcion;

    @NotNull
    @Size(max = 2000, message = "no cumple con la longitud")
    private String imgPerfil;

    @Size(max = 2000, message = "no cumple con la longitud")
    private String linkedin;

    @Size(max = 2000, message = "no cumple con la longitud")
    private String instagram;

    @Size(max = 2000, message = "no cumple con la longitud")
    private String github;

    @NotNull
    @Size(max = 2000, message = "no cumple con la longitud")
    private String imgBanner;

    @NotNull
    @Size(min = 10, max = 45, message = "no cumple con la longitud")
    private String email;

//    @NotNull
    @Size(min = 8, max = 25, message = "no cumple con la longitud")
    private String password;

    @Transient
    private String token;

    //listas de relaciones
    @OneToMany(mappedBy = "persona",fetch = FetchType.LAZY)
    private List<Experiencia> listaExperiencias;

    @OneToMany(mappedBy = "persona",fetch = FetchType.LAZY)
    private List<Habilidad> listaHabilidades;

    @OneToMany(mappedBy = "persona",fetch = FetchType.LAZY)
    private List<Proyecto> listaProyectos;

    public Persona() {
    }

    public Persona(String fullName, String titulo, String descripcion, String imgPerfil,
                   String linkedin, String instagram, String github, String imgBanner, String email, String password) {
        this.fullName = fullName;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.imgPerfil = imgPerfil;
        this.linkedin = linkedin;
        this.instagram = instagram;
        this.github = github;
        this.imgBanner = imgBanner;
        this.email = email;
        this.password = password;
    }

    public Persona(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
