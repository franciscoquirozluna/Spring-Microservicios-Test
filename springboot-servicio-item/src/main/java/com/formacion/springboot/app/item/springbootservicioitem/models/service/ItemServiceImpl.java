package com.formacion.springboot.app.item.springbootservicioitem.models.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.formacion.springboot.app.item.springbootservicioitem.models.Item;
import com.formacion.springboot.app.item.springbootservicioitem.models.Producto;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

//@Primary
@Service
public class ItemServiceImpl implements ItemService{

    @Autowired
    private RestTemplate clienteRest;

    @Override
    public List<Item> findAll() {
        List<Producto> productos = Arrays.asList(clienteRest.getForObject("http://localhost:8001/listar", Producto[].class));
        return productos.stream().map(p -> new Item(p, 1)).collect(Collectors.toList());
    }

    @Override
    public Item findById(Long id, Integer cantidad) {
        Map<String,String> parametros = new HashMap<String,String>();
        parametros.put("id", id.toString());

        Producto producto = clienteRest.getForObject("http://localhost:8001/buscar/{id}", Producto.class, parametros);
        return new Item(producto, cantidad);
    }
}
