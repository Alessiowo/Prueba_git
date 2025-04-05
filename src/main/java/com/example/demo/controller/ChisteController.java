package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import com.example.demo.model.Chiste;
import com.example.demo.service.ChisteService;

import java.util.List;

@RestController
public class ChisteController {

    private final ChisteService chisteService;

    public ChisteController(ChisteService chisteService) {
        this.chisteService = chisteService;
    }

    // Endpoint para obtener todos los chistes
    @GetMapping("/chistes")
    public List<Chiste> obtenerTodosLosChistes() {
        return chisteService.todos();
    }

    // Endpoint para obtener un chiste por su ID
    @GetMapping("/chistes/{id}")
    public Chiste obtenerChistePorId(@PathVariable int id) {
        return chisteService.obtenerChiste(id);
    }

    // Endpoint para obtener un chiste aleatorio
    @GetMapping("/chistes/aleatorio")
    public Chiste obtenerChisteAleatorio() {
        return chisteService.obtenerChisteAleatorio();
    }

    // Endpoint para agregar un nuevo chiste
    @PostMapping("/chistes")
    public void agregarNuevoChiste(@RequestBody Chiste chiste) {
        chisteService.agregarChiste(chiste);
    }

    // Endpoint para actualizar un chiste existente
    @PutMapping("/chistes/{id}")
    public void actualizarChiste(@PathVariable int id, @RequestBody Chiste nuevoChiste) {
        chisteService.actualizarChiste(id, nuevoChiste);
    }

    // Endpoint para eliminar un chiste por su ID
    @DeleteMapping("/chistes/{id}")
    public void eliminarChiste(@PathVariable int id) {
        chisteService.eliminarChiste(id);
    }
}
