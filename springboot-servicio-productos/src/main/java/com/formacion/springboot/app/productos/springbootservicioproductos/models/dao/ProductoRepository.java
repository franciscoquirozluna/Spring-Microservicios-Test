package com.formacion.springboot.app.productos.springbootservicioproductos.models.dao;

import com.formacion.springboot.app.productos.springbootservicioproductos.models.entity.Producto;

import org.springframework.data.repository.CrudRepository;

public interface ProductoRepository extends CrudRepository<Producto,Long>{
    
}
