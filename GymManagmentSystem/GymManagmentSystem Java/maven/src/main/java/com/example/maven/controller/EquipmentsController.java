package com.example.maven.controller;

import com.example.maven.pojo.Equipments.CreateEquipmentsInput;
import com.example.maven.pojo.Equipments.Equipments;
import com.example.maven.pojo.Trainer.Trainer;
import com.example.maven.service.EquipmentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EquipmentsController {
    @Autowired
    EquipmentsService equipmentsService;

    @GetMapping("/equipments")
    public List<Equipments> getAll(){ return equipmentsService.findAll();}

    @PostMapping("/equipments")
    public Equipments create(@RequestBody CreateEquipmentsInput input){
        Integer newEquipId=input.getId();
        String newEquipName=input.getName();
        Integer newEquipPrice=input.getPrice();
        Integer newEquipQuantity=input.getQuantity();

        return equipmentsService.create(newEquipId,newEquipName,newEquipPrice,newEquipQuantity);
    }
    @DeleteMapping("/equipment/{id}")
    public void delete(@PathVariable Integer id){
        equipmentsService.delete(id);
    }
}
