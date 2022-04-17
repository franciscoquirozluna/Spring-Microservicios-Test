package com.formacion.springboot.app.item.springbootservicioitem.clientes;

import java.util.List;

import com.formacion.springboot.app.item.springbootservicioitem.models.Producto;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="servicio-productos", url="http://localhost:8001")
public interface ProductoClienteRest {


    @GetMapping("/listar")
    public List<Producto> findAll();    
    
    @GetMapping(value="/buscar/{id}")
    public Producto findById(@PathVariable Long id);
}
