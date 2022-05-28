package com.portfolio.alegodoy.service;

import com.portfolio.alegodoy.model.Habilidad;

import java.util.List;

public interface IHabilidadService {

    public Habilidad save(Habilidad habilidad);

    public List<Habilidad> get();

    public Habilidad getById(Long id);

    public String delete(Long id);

    public Habilidad edit(Long id, String imgLogo, String porcentaje);
}
