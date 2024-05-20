package com.example.maven.service;

import com.example.maven.pojo.Trainer.Trainer;

import java.util.ArrayList;
import java.util.List;

public interface TrainerService {

    List<Trainer> findAll();
    Trainer findOneById(Integer id);
    Trainer create(Integer id, String name, Integer age);
    Trainer edit(Integer id,String name);
    void delete(Integer id);

}
