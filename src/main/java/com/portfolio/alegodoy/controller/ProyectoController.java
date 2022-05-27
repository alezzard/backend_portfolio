package com.portfolio.alegodoy.controller;

import com.portfolio.alegodoy.model.Proyecto;
import com.portfolio.alegodoy.service.IProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proyecto")
public class ProyectoController {

    @Autowired
    private IProyectoService iProyectoService;

    @PostMapping("/crear")
    public Proyecto crearProyecto(@RequestBody Proyecto proyecto){
        return iProyectoService.save(proyecto);
    }

    @GetMapping("/traer")
    public List<Proyecto> traerProyecto(){
        return iProyectoService.get();
    }

    @GetMapping("/traer/{id}")
    public Proyecto traerProyectoPorId(@PathVariable Long id){
        return iProyectoService.getById(id);
    }

    @DeleteMapping("/borrar/{id}")
    public String borrarProyecto(@PathVariable Long id){
        return iProyectoService.delete(id);
    }

    @PutMapping("/editar/{id}")
    public Proyecto editarProyecto(@PathVariable Long id,@RequestParam String nombre,@RequestParam String fecha,
                            @RequestParam String descripcion,@RequestParam String imgProyecto,@RequestParam String link){
        return iProyectoService.edit(id,nombre,fecha,descripcion,imgProyecto,link);
    }
}
