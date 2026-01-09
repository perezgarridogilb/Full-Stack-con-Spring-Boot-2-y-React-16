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
import com.ventas.ventas.model.TipoProducto;
import com.ventas.ventas.service.DetalleVentaService;
import com.ventas.ventas.service.TipoProductoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/tipoProducto")
public class TipoProductoController {

        @Autowired
    private TipoProductoService tipoProductoService;

        @GetMapping
    public ResponseEntity<List<TipoProducto>> findAll() {
        return ResponseEntity.ok(tipoProductoService.findAll());
    }

        @GetMapping("/{id}")
    public  ResponseEntity<TipoProducto> findById(@PathVariable("id") Integer idTipoProducto) {
        return tipoProductoService.findById(idTipoProducto)
        .map(ResponseEntity::ok)
        .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PostMapping
    /** valid es código de error correcto */
    public ResponseEntity<TipoProducto> create(@Valid @RequestBody TipoProducto cliente) {
        return new ResponseEntity<>(tipoProductoService.create(cliente), HttpStatus.CREATED);
    }

    @PutMapping
    /** valid es código de error correcto */
    public ResponseEntity<TipoProducto> update(@Valid @RequestBody TipoProducto tipoProducto) {
        ObjectMapper mapper = new ObjectMapper();
        // mapper.writeValueAsString(cliente)
        return tipoProductoService.findById(tipoProducto.getIdTipoProducto()
        ).map(c -> ResponseEntity.ok(tipoProductoService.update(tipoProducto)))
        .orElseGet(() -> ResponseEntity.notFound().build());

    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Integer tipoProducto) {
        return tipoProductoService.findById(tipoProducto)
                .map(c -> {
                    tipoProductoService.delete(tipoProducto);
                    return ResponseEntity.ok().build();
                }).orElseGet(() -> ResponseEntity.notFound().build());
    }

}
