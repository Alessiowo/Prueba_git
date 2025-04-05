package com.example.demo.service;

import com.example.demo.model.Chiste;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChisteService {

    private List<Chiste> chistes;

    public ChisteService() {
        chistes = new ArrayList<>();
        chistes.add(new Chiste(1, "¿Qué le dice un 0 a un 8? Bonito cinturón.", "Juan"));
        chistes.add(new Chiste(2, "¿Qué hace una abeja en el gimnasio? ¡Zum-ba!", "Marcos"));
        chistes.add(new Chiste(3, "¿Cuál es el colmo de un electricista? Que su hijo sea un apagado.", "Luis"));
        chistes.add(new Chiste(4, "¿Por qué estás hablando con la pared? ¡Porque la mesa no me responde!", "Anonimo"));
    }

    public List<Chiste> todos() {
        return chistes;
    }

    public Chiste obtenerChisteAleatorio() {
        return chistes.get((int) (Math.random() * chistes.size()));
    }

    public void agregarChiste(Chiste chiste) {
        chistes.add(chiste);
    }

    public Chiste obtenerChiste(int id) {
        for (Chiste chiste : chistes) {
            if (chiste.getId() == id) {
                return chiste;
            }
        }
        return null;
    }

    public void actualizarChiste(int id, Chiste nuevoChiste) {
        Chiste chisteExistente = obtenerChiste(id);
        if (chisteExistente != null) {
            chisteExistente.setTexto(nuevoChiste.getTexto());
            chisteExistente.setAutor(nuevoChiste.getAutor());
        }
    }

    public void eliminarChiste(int id) {
        chistes.removeIf(chiste -> chiste.getId() == id);
    }
}
