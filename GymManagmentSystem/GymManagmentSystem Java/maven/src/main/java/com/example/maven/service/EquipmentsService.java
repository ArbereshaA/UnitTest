package com.example.maven.service;

import com.example.maven.pojo.Equipments.Equipments;
import com.example.maven.pojo.Trainer.Trainer;

import java.util.List;

public interface EquipmentsService {
    List<Equipments> findAll();
    Equipments create(Integer id,String name,Integer price,Integer quantity);
    void delete(Integer id);

}
