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
    public Persona findByEmail(String email) {
        return iPersonaRepository.findByEmail(email);
    }

    @Override
    public String delete(Long id) {
        iPersonaRepository.deleteById(id);
        return "Persona eliminada con éxito!";
    }

    @Override
    public Persona edit(Long id,Persona persona) {
        Persona newPersona = iPersonaRepository.findById(id).orElse(null);
        newPersona.setFullName(persona.getFullName());
        newPersona.setTitulo(persona.getTitulo());
        newPersona.setDescripcion(persona.getDescripcion());
        newPersona.setImgPerfil(persona.getImgPerfil());
        newPersona.setLinkedin(persona.getLinkedin());
        newPersona.setInstagram(persona.getInstagram());
        newPersona.setGithub(persona.getGithub());
        newPersona.setImgBanner(persona.getImgBanner());
        newPersona.setEmail(persona.getEmail());
        newPersona.setPassword(persona.getPassword());
        return iPersonaRepository.save(newPersona);
    }
}
