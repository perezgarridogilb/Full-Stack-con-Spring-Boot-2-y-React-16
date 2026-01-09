package com.ventas.ventas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ventas.ventas.model.Cliente;
import com.ventas.ventas.model.Venta;
import com.ventas.ventas.service.ClienteService;
import com.ventas.ventas.service.VentaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/venta")
public class VentaController {

        @Autowired
    private VentaService ventaService;

        @GetMapping
    public ResponseEntity<List<Venta>> findAll() {
        return ResponseEntity.ok(ventaService.findAll());
    }

        @GetMapping("/{id}")
    public  ResponseEntity<Venta> findById(@PathVariable("id") Integer idVenta) {
        return ventaService.findById(idVenta)
        .map(ResponseEntity::ok)
        .orElseGet(() -> ResponseEntity.notFound().build());
    }

        @PostMapping
    /** valid es código de error correcto */
    public ResponseEntity<Venta> create(@Valid @RequestBody Venta cliente) {
        return new ResponseEntity<>(ventaService.create(cliente), HttpStatus.CREATED);
    }

        @PutMapping
    /** valid es código de error correcto */
    public ResponseEntity<Venta> update(@Valid @RequestBody Venta venta) {
        ObjectMapper mapper = new ObjectMapper();
        // mapper.writeValueAsString(cliente)
        return ventaService.findById(venta.getIdVenta()
        ).map(c -> ResponseEntity.ok(ventaService.update(venta)))
        .orElseGet(() -> ResponseEntity.notFound().build());

    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Integer idVenta) {
        return ventaService.findById(idVenta)
                .map(c -> {
                    ventaService.delete(idVenta);
                    return ResponseEntity.ok().build();
                }).orElseGet(() -> ResponseEntity.notFound().build());
    }

}
