package com.portfolio.alegodoy.controller;

import com.portfolio.alegodoy.model.Habilidad;
import com.portfolio.alegodoy.service.IHabilidadService;
import com.portfolio.alegodoy.service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/habilidad")
@CrossOrigin(origins = "http://localhost:4200")
public class HabilidadController {

    @Autowired
    private IHabilidadService iHabilidadService;

    @Autowired
    private IPersonaService iPersonaService;

    @PostMapping("/crear/{id}")
    public Habilidad crearHabilidad(@PathVariable Long id,@RequestBody Habilidad habilidad){
        habilidad.setPersona(iPersonaService.findById(id));
        return iHabilidadService.save(habilidad);
    }

    @GetMapping("/traer")
    public List<Habilidad> traerHabilidad(){
        return iHabilidadService.get();
    }

    @GetMapping("/traer/{id}")
    public Habilidad traerHabilidadPorId(@PathVariable Long id){
        return iHabilidadService.getById(id);
    }

    @DeleteMapping("/borrar/{id}")
    public String borrarHabilidad(@PathVariable Long id){
        return iHabilidadService.delete(id);
    }

    @PutMapping("/editar/{id}")
    public Habilidad editarHabilidad(@PathVariable Long id, @RequestParam String imgLogo, @RequestParam String porcentaje){
        return iHabilidadService.edit(id,imgLogo,porcentaje);
    }
}
