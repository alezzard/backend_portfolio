package com.portfolio.alegodoy.service;

import com.portfolio.alegodoy.model.Persona;

public interface IPersonaService {
    public Persona save(Persona persona);

    public Persona findById(Long id);

    public String delete(Long id);

    public Persona edit(Long id,String nombre, String apellido,
                        String titulo, String descripcion,
                        String imgPerfil);
}
