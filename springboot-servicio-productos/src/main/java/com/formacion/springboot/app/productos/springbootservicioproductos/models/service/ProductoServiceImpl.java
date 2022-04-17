package com.formacion.springboot.app.productos.springbootservicioproductos.models.service;

import java.util.List;

import com.formacion.springboot.app.productos.springbootservicioproductos.models.dao.ProductoRepository;
import com.formacion.springboot.app.productos.springbootservicioproductos.models.entity.Producto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductoServiceImpl implements IProductoService{

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Producto> findAll() {       
        return (List<Producto>) productoRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Producto findById(Long id) {        
        return productoRepository.findById(id).orElse(null);
    }
    
}
