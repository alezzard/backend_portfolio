package com.portfolio.alegodoy.service;

import com.portfolio.alegodoy.model.Habilidad;
import com.portfolio.alegodoy.repository.IHabilidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabilidadService implements IHabilidadService{

    @Autowired
    private IHabilidadRepository iHabilidadRepository;

    @Override
    public Habilidad save(Habilidad habilidad) {
        return iHabilidadRepository.save(habilidad);
    }

    @Override
    public List<Habilidad> get() {
        return iHabilidadRepository.findAll();
    }

    @Override
    public Habilidad getById(Long id) {
        return iHabilidadRepository.findById(id).orElse(null);
    }

    @Override
    public String delete(Long id) {
        iHabilidadRepository.deleteById(id);
        return "Habilidad eliminada con éxito!";
    }

    @Override
    public Habilidad edit(Long id, Habilidad habilidad) {
        Habilidad newHabilidad = iHabilidadRepository.findById(id).orElse(null);

        newHabilidad.setImgLogo(habilidad.getImgLogo());
        newHabilidad.setPorcentaje(habilidad.getPorcentaje());

        return iHabilidadRepository.save(newHabilidad);
    }
}
