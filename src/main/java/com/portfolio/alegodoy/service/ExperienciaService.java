package com.portfolio.alegodoy.service;

import com.portfolio.alegodoy.model.Experiencia;
import com.portfolio.alegodoy.repository.IExperienciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExperienciaService implements IExperienciaService{

    @Autowired
    private IExperienciaRepository iExperienciaRepository;

    @Override
    public Experiencia save(Experiencia experiencia) {
        return iExperienciaRepository.save(experiencia);
    }

    @Override
    public List<Experiencia> get() {
        return iExperienciaRepository.findAll();
    }

    @Override
    public Experiencia getById(Long id) {
        return iExperienciaRepository.findById(id).orElse(null);
    }

    @Override
    public String delete(Long id) {
        iExperienciaRepository.deleteById(id);
        return "Experiencia eliminada con éxito!";
    }

    @Override
    public Experiencia edit(Long id, String titulo, String periodo, String descripcion,
                            String imgLogo, boolean tipo) {

        Experiencia experiencia = iExperienciaRepository.findById(id).orElse(null);

        experiencia.setTitulo(titulo);
        experiencia.setPeriodo(periodo);
        experiencia.setDescripcion(descripcion);
        experiencia.setImgLogo(imgLogo);
        experiencia.setTipo(tipo);

        return iExperienciaRepository.save(experiencia);
    }
}
