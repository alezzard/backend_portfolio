package com.portfolio.alegodoy.controller;

import com.portfolio.alegodoy.model.Habilidad;
import com.portfolio.alegodoy.service.IHabilidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/habilidad")
public class HabilidadController {

    @Autowired
    private IHabilidadService iHabilidadService;

    @PostMapping("/crear")
    public Habilidad crearHabilidad(@RequestBody Habilidad habilidad){
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
    public Habilidad editarHabilidad(@PathVariable Long id, @RequestParam String nombre, @RequestParam int porcentaje){
        return iHabilidadService.edit(id,nombre,porcentaje);
    }
}
