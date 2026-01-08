package com.ventas.ventas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.ventas.ventas.model.DetalleVenta;
import com.ventas.ventas.model.Persona;
import com.ventas.ventas.repository.IDetalleVentaRepository;

public class DetalleVentaService implements ICRUDService<DetalleVenta> {

                @Autowired
    private IDetalleVentaRepository detalleVentaRepository;

    @Override
    public List<DetalleVenta> findAll() {
        return detalleVentaRepository.findAll();
    }

    @Override
    public Optional<DetalleVenta> findById(Integer id) {
        return detalleVentaRepository.findById(id);
    }

    @Override
    public DetalleVenta create(DetalleVenta model) {
        return detalleVentaRepository.save(model);
    }

    @Override
    public DetalleVenta update(DetalleVenta model) {
                return detalleVentaRepository.save(model);

    }

    @Override
    public void delete(Integer id) {
                detalleVentaRepository.deleteById(id);

    }

}
