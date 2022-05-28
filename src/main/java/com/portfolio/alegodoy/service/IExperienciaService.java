package com.portfolio.alegodoy.service;

import com.portfolio.alegodoy.model.Experiencia;

import java.util.List;

public interface IExperienciaService {

    public Experiencia save(Experiencia experiencia);

    public List<Experiencia> fineByTipo(boolean tipo);

    public Experiencia getById(Long id);

    public String delete(Long id);

    public Experiencia edit(Long id,String titulo, String periodo, String descripcion,
                            String imgLogo, boolean tipo);
}
