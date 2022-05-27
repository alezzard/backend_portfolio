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
public class Proyecto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 3, max = 45, message = "no cumple con la longitud")
    private String nombre;

    @NotNull
    @Size(min = 3, max = 25, message = "no cumple con la longitud")
    private String fecha;

    @NotNull
    @Size(min = 3, max = 250, message = "no cumple con la longitud")
    private String descripcion;

    @NotNull
    @Size(min = 3, max = 250, message = "no cumple con la longitud")
    private String imgProyecto;

    @NotNull
    @Size(min = 3, max = 250, message = "no cumple con la longitud")
    private String link;

    public Proyecto() {
    }

    public Proyecto(String nombre, String fecha, String descripcion, String imgProyecto, String link){
        this.nombre = nombre;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.imgProyecto = imgProyecto;
        this.link = link;
    }
}
