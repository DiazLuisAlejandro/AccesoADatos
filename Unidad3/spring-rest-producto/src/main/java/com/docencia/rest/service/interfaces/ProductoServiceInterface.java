package com.docencia.rest.service.interfaces;

import java.util.List;
import java.util.Optional;

import com.docencia.rest.model.ProductoEntity;

public interface ProductoServiceInterface {
    public List<ProductoEntity> findAll();

    public Optional<ProductoEntity> find(ProductoEntity producto);

    public Optional<ProductoEntity> findById(int productoId);

    public boolean deleteById(int id);

    public boolean deleteProducto(ProductoEntity producto);

    public ProductoEntity save(ProductoEntity producto);
}
