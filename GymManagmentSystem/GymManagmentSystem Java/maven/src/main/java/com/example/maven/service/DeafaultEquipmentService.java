package com.example.maven.service;

import com.example.maven.pojo.Equipments.Equipments;
import com.example.maven.repository.EquipmentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeafaultEquipmentService implements EquipmentsService{
    @Autowired
    EquipmentsRepository equipmentsRepository;

    @Override
    public List<Equipments> findAll() {
        return equipmentsRepository.findAll();
    }

    @Override
    public Equipments create(Integer id, String name, Integer price, Integer quantity) {
        Equipments equipments=new Equipments();
        equipments.setId(id);
        equipments.setName(name);
        equipments.setPrice(price);
        equipments.setQuantity(quantity);
//        return EquipmentsRepository.save(
       return equipmentsRepository.save(equipments);
    }

    @Override
    public void delete(Integer id) {
        equipmentsRepository.deleteById(id);
    }
}
