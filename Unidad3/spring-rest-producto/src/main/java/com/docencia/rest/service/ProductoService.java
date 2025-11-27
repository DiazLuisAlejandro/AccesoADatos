package com.docencia.rest.service;

import com.docencia.rest.repository.interfaces.DetalleProductoRepository;
import com.docencia.rest.repository.interfaces.ProductoRepository;
import com.docencia.rest.service.interfaces.ProductoServiceInterface;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.docencia.rest.model.ProductoEntity;

@Component
public class ProductoService implements ProductoServiceInterface {

    private ProductoRepository productoRepository;

    private DetalleProductoRepository detalleProductoRepository;

    @Autowired
    public void setProductoRepository(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    
    public void setDetalleProductoDocument(DetalleProductoRepository detalleProductoRepository) {
        this.detalleProductoRepository = detalleProductoRepository;
    }

    @Override
    public List<ProductoEntity> findAll() {
        return productoRepository.findAll();
    }

    @Override
    public Optional<ProductoEntity> find(ProductoEntity producto) {
        return findById(producto.getId());
    }

    @Override
    public Optional<ProductoEntity> findById(int productoId) {
        return productoRepository.findById(productoId);
    }

    @Override
    public boolean deleteProducto(ProductoEntity producto) {
        productoRepository.delete(producto);
        return true;
    }

    @Override
    public boolean deleteById(int id) {
        ProductoEntity producto = new ProductoEntity(id);
        return deleteProducto(producto);
    }

    @Override
    public ProductoEntity save(ProductoEntity producto) {
        return productoRepository.save(producto);
    }

}