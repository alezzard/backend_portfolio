package com.portfolio.alegodoy.controller;

import com.portfolio.alegodoy.model.Persona;
import com.portfolio.alegodoy.service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/persona")
@CrossOrigin(origins = "http://localhost:4200")
public class PersonaController {

    @Autowired
    private IPersonaService iPersonaService;

    @PostMapping("/crear")
    public Persona crearPersona(@RequestBody Persona persona){
        return iPersonaService.save(persona);
    }

    @GetMapping("/traer/{id}")
    public Persona traerPersona(@PathVariable Long id){
        return iPersonaService.findById(id);
    }

    @DeleteMapping("/borrar/{id}")
    public String borrarPersona(@PathVariable Long id){
        return iPersonaService.delete(id);
    }

    @PutMapping("/editar/{id}")
    public Persona editarPersona(@PathVariable Long id,@RequestParam String nombre,
                                @RequestParam String apellido,@RequestParam String titulo,
                                @RequestParam String descripcion,@RequestParam String imgPerfil) {
        return iPersonaService.edit(id, nombre, apellido, titulo, descripcion, imgPerfil);
    }

}
