package com.formacion.springboot.app.item.springbootservicioitem.models.service;

import java.util.List;

import com.formacion.springboot.app.item.springbootservicioitem.models.Item;

public interface ItemService {

    public List<Item> findAll();
    public Item findById(Long id, Integer cantidad) ;
      
}
