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
import com.ventas.ventas.model.DetalleVenta;
import com.ventas.ventas.model.TipoProducto;
import com.ventas.ventas.service.DetalleVentaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/detalleVenta")
public class DetalleVentaController {

    @Autowired
    private DetalleVentaService detalleVentaService;

    @GetMapping
    public ResponseEntity<List<DetalleVenta>> findAll() {
        return ResponseEntity.ok(detalleVentaService.findAll());
    }

        @PostMapping
    /** valid es código de error correcto */
    public ResponseEntity<DetalleVenta> create(@Valid @RequestBody DetalleVenta cliente) {
        return new ResponseEntity<>(detalleVentaService.create(cliente), HttpStatus.CREATED);
    }

            @GetMapping("/{id}")
    public  ResponseEntity<DetalleVenta> findById(@PathVariable("id") Integer idDetalleVenta) {
        return detalleVentaService.findById(idDetalleVenta)
        .map(ResponseEntity::ok)
        .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping
    /** valid es código de error correcto */
    public ResponseEntity<DetalleVenta> update(@Valid @RequestBody DetalleVenta detalleVenta) {
        ObjectMapper mapper = new ObjectMapper();
        // mapper.writeValueAsString(cliente)
        return detalleVentaService.findById(detalleVenta.getIdDetalleVenta()
        ).map(c -> ResponseEntity.ok(detalleVentaService.update(detalleVenta)))
        .orElseGet(() -> ResponseEntity.notFound().build());

    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Integer idDetalleVenta) {
        return detalleVentaService.findById(idDetalleVenta)
                .map(c -> {
                    detalleVentaService.delete(idDetalleVenta);
                    return ResponseEntity.ok().build();
                }).orElseGet(() -> ResponseEntity.notFound().build());
    }

}
