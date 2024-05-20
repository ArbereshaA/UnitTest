package com.example.maven.controller;

import org.springframework.web.bind.annotation.RestController;
import com.example.maven.pojo.Member.Member;
import com.example.maven.pojo.Trainer.CreateTrainerInput;
import com.example.maven.pojo.Trainer.EditTrainerInput;
import com.example.maven.pojo.Trainer.Trainer;
import com.example.maven.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;

@RestController
public class TrainerController {
    @Autowired
TrainerService trainerService;


    @GetMapping("/trainer")
    public List<Trainer> getAll(){ return trainerService.findAll();}

    @GetMapping("/trainer/{id}")
    public Trainer getOneById(@PathVariable Integer id){ return trainerService.findOneById(id);}

    @PostMapping("/trainer")
    public Trainer create(@RequestBody CreateTrainerInput input){
        Integer newTrainerId=input.getId();
        String newTrainerName=input.getName();
        Integer newTrainerAge=input.getAge();

        return trainerService.create(newTrainerId,newTrainerName,newTrainerAge);
    }

    @PutMapping("/trainer/{id}")
    public Trainer edit(@PathVariable Integer id,
                        @RequestBody EditTrainerInput input){
        return trainerService.edit(id,input.getName());
    }
    @DeleteMapping("/trainer/{id}")
    public void delete(@PathVariable Integer id){
        trainerService.delete(id);
    }
}
