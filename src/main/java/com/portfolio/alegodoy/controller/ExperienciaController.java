package com.portfolio.alegodoy.controller;

import com.portfolio.alegodoy.model.Experiencia;
import com.portfolio.alegodoy.service.IExperienciaService;
import com.portfolio.alegodoy.service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/experiencia")
@CrossOrigin(origins = "http://localhost:4200")
public class ExperienciaController {

    @Autowired
    private IExperienciaService iExperienciaService;

    @Autowired
    private IPersonaService iPersonaService;

    @PostMapping("/crear/{id}")
    public Experiencia crearExperiencia(@PathVariable Long id,@RequestBody Experiencia experiencia){
        experiencia.setPersona(iPersonaService.findById(id));
        return iExperienciaService.save(experiencia);
    }

    @GetMapping("/traer/laboral")
    public List<Experiencia> traerExperienciasLaborales(){return iExperienciaService.fineByTipo(true);}

    @GetMapping("/traer/academica")
    public List<Experiencia> traerExperienciasAcademicas(){return iExperienciaService.fineByTipo(false);}

    @GetMapping("/traer/{id}")
    public Experiencia traerExperienciaPorId(@PathVariable Long id){
        return iExperienciaService.getById(id);
    }

    @DeleteMapping("/borrar/{id}")
    public String borrarExperiencia(@PathVariable  Long id){ return iExperienciaService.delete(id);}

    @PutMapping("/editar/{id}")
    public Experiencia editarExperiencia(@PathVariable  Long id,@RequestBody Experiencia experiencia){
        return iExperienciaService.edit(id,experiencia);
    }
}
