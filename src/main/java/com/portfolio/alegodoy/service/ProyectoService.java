package com.portfolio.alegodoy.service;

import com.portfolio.alegodoy.model.Proyecto;
import com.portfolio.alegodoy.repository.IProyectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProyectoService implements IProyectoService{

    @Autowired
    private IProyectoRepository iProyectoRepository;

    @Override
    public Proyecto save(Proyecto proyecto) {
        return iProyectoRepository.save(proyecto);
    }

    @Override
    public List<Proyecto> get() {
        return iProyectoRepository.findAll();
    }

    @Override
    public Proyecto getById(Long id) {
        return iProyectoRepository.findById(id).orElse(null);
    }

    @Override
    public String delete(Long id) {
        iProyectoRepository.deleteById(id);
        return "Proyecto eliminado con éxito! ";
    }

    @Override
    public Proyecto edit(Long id, Proyecto proyecto){
        Proyecto newProyecto = iProyectoRepository.findById(id).orElse(null);
        newProyecto.setNombre(proyecto.getNombre());
        newProyecto.setPeriodo(proyecto.getPeriodo());
        newProyecto.setDescripcion(proyecto.getDescripcion());
        newProyecto.setImgProyecto(proyecto.getImgProyecto());
        newProyecto.setLink(proyecto.getLink());
        return newProyecto;
    }
}
