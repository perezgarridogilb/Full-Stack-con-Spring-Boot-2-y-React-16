package com.ventas.ventas.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ventas.ventas.model.Persona;
import com.ventas.ventas.service.PersonaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/personas")
public class PersonaController {

    private final PersonaService personaService;

    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }

    @GetMapping
    public ResponseEntity<List<Persona>> findAll() {
        return ResponseEntity.ok(personaService.findAll());
    }

    @PostMapping
    public ResponseEntity<Persona> create(@Valid @RequestBody Persona persona) {
        return new ResponseEntity<>(personaService.create(persona), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Persona> findById(@PathVariable("id") Integer idPersona) {
        return personaService.findById(idPersona)
        .map(ResponseEntity::ok)
        .orElseGet(() -> ResponseEntity.notFound().build());

        // .map(p -> ResponseEntity.ok(personaService.update(persona)));
    }

    @PutMapping
    public ResponseEntity<Persona> update(@Valid @RequestBody Persona persona) {
        return personaService.findById(persona.getIdPersona())
        .map(p -> ResponseEntity.ok(personaService.update(persona)))
        .orElseGet(() -> ResponseEntity.notFound().build());

        // .map(p -> ResponseEntity.ok(personaService.update(persona)));
    }

        @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Integer idPersona) {
        return personaService.findById(idPersona)
        .map(p -> {
            personaService.delete(idPersona);
            return ResponseEntity.ok().build();
        }).orElseGet(() -> ResponseEntity.notFound().build());
    
    

        // .map(p -> ResponseEntity.ok(personaService.update(persona)));
    }
}
