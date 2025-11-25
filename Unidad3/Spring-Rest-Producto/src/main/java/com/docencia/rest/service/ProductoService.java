package com.docencia.rest.service;

import com.docencia.rest.repository.ProductoRepository;
import com.docencia.rest.service.interfaces.ProductoServiceInterface;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;
import com.docencia.rest.model.Producto;

@Component
public class ProductoService implements ProductoServiceInterface {

    private ProductoRepository productoRepository;

    @Override
    public List<Producto> findAll() {
        return productoRepository.findAll();
    }

    @Override
    public Optional<Producto> find(Producto producto) {
        return findById(producto.getId());
    }

    @Override
    public Optional<Producto> findById(int productoId) {
        return productoRepository.findById(productoId);
    }

    @Override
    public boolean deleteProducto(Producto producto) {
        productoRepository.delete(producto);
        return true;
    }

    @Override
    public boolean deleteById(int id) {
        Producto producto=new Producto(id);
        return deleteProducto(producto);
    }

    @Override
    public Producto save(Producto producto) {
        return productoRepository.save(producto);
    }

}