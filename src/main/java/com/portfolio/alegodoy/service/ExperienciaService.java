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
    public List<Experiencia>  fineByTipo(boolean tipo) {
        return iExperienciaRepository.findByTipo(tipo);
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
    public Experiencia edit(Long id, Experiencia experiencia) {

        Experiencia newExperiencia = iExperienciaRepository.findById(id).orElse(null);

        newExperiencia.setTitulo(experiencia.getTitulo());
        newExperiencia.setPeriodo(experiencia.getPeriodo());
        newExperiencia.setDescripcion(experiencia.getDescripcion());
        newExperiencia.setImgLogo(experiencia.getImgLogo());
        newExperiencia.setTipo(experiencia.isTipo());

        return iExperienciaRepository.save(newExperiencia);
    }
}
