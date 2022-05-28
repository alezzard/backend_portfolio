package com.portfolio.alegodoy.service;


import com.portfolio.alegodoy.model.Proyecto;

import java.util.List;

public interface IProyectoService {

    public Proyecto save(Proyecto proyecto);

    public List<Proyecto> get();

    public Proyecto getById(Long id);

    public String delete(Long id);

    public Proyecto edit(Long id,String nombre, String periodo, String descripcion,
                         String imgProyecto, String link);

}
