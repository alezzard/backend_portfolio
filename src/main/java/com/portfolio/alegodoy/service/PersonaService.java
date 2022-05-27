package com.portfolio.alegodoy.service;

import com.portfolio.alegodoy.model.Persona;
import com.portfolio.alegodoy.repository.IPersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService implements IPersonaService{

    @Autowired
    private IPersonaRepository iPersonaRepository;

    @Override
    public Persona save(Persona persona) {
        return iPersonaRepository.save(persona);
    }

    @Override
    public Persona findById(Long id) {
        return iPersonaRepository.findById(id).orElse(null);
    }

    @Override
    public String delete(Long id) {
        iPersonaRepository.deleteById(id);
        return "Persona eliminada con éxito!";
    }

    @Override
    public Persona edit(Long id, String nombre, String apellido, String titulo,
                        String descripcion, String imgPerfil) {
        Persona persona = iPersonaRepository.findById(id).orElse(null);
        persona.setNombre(nombre);
        persona.setApellido(apellido);
        persona.setTitulo(titulo);
        persona.setDescripcion(descripcion);
        persona.setImgPerfil(imgPerfil);
        return iPersonaRepository.save(persona);
    }
}
