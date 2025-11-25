package com.docencia.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.docencia.rest.model.Producto;
import com.docencia.rest.service.ProductoService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/v1/producto")
public class ProductoController {
    
    private ProductoService productoService;

    @Autowired
    public void setProductoService(ProductoService productoService) {
        this.productoService = productoService;
    }

    @Operation(summary = "Get all users")
    @GetMapping("/")
    public List<Producto> getAllProducts() {
        return productoService.findAll();
    }
}
