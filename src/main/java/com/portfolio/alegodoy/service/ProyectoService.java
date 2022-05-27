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
        return "Proyecto eliminado con éxito! ";
    }

    @Override
    public Proyecto edit(Long id, String nombre, String fecha, String descripcion, String imgProyecto, String link){
        Proyecto proyecto = iProyectoRepository.findById(id).orElse(null);
        proyecto.setNombre(nombre);
        proyecto.setFecha(fecha);
        proyecto.setDescripcion(descripcion);
        proyecto.setImgProyecto(imgProyecto);
        proyecto.setLink(link);
        return proyecto;
    }
}
