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
import com.ventas.ventas.model.Producto;
import com.ventas.ventas.model.TipoProducto;
import com.ventas.ventas.service.ProductoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/producto")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping
    public ResponseEntity<List<Producto>> findAll() {
        return ResponseEntity.ok(productoService.findAll());
    }


        @GetMapping("/{id}")
    public  ResponseEntity<Producto> findById(@PathVariable("id") Integer Producto) {
        return productoService.findById(Producto)
        .map(ResponseEntity::ok)
        .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PostMapping
    /** valid es código de error correcto */
    public ResponseEntity<Producto> create(@Valid @RequestBody Producto Producto) {
        return new ResponseEntity<>(productoService.create(Producto), HttpStatus.CREATED);
    }

    @PutMapping
    /** valid es código de error correcto */
    public ResponseEntity<Producto> update(@Valid @RequestBody Producto Producto) {
        ObjectMapper mapper = new ObjectMapper();
        // mapper.writeValueAsString(cliente)
        return productoService.findById(Producto.getIdProducto()
        ).map(c -> ResponseEntity.ok(productoService.update(Producto)))
        .orElseGet(() -> ResponseEntity.notFound().build());

    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Integer Producto) {
        return productoService.findById(Producto)
                .map(c -> {
                    productoService.delete(Producto);
                    return ResponseEntity.ok().build();
                }).orElseGet(() -> ResponseEntity.notFound().build());
    }
}

