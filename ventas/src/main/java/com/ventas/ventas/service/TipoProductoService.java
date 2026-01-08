package com.ventas.ventas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.ventas.ventas.model.Producto;
import com.ventas.ventas.model.TipoProducto;
import com.ventas.ventas.repository.IProductoRepository;
import com.ventas.ventas.repository.ITipoProductoRepository;

public class TipoProductoService implements ICRUDService<TipoProducto> {

        @Autowired
    private ITipoProductoRepository tipoProductoRepository;
    @Override
    public List<TipoProducto> findAll() {
        return tipoProductoRepository.findAll();
    }

    @Override
    public Optional<TipoProducto> findById(Integer id) {
        return tipoProductoRepository.findById(id);
    }

    @Override
    public TipoProducto create(TipoProducto model) {
        return tipoProductoRepository.save(model);
    }

    @Override
    public TipoProducto update(TipoProducto model) {
        return tipoProductoRepository.save(model);
    }

    @Override
    public void delete(Integer id) {
        tipoProductoRepository.deleteById(id);
    }

}
