package com.example.maven.service;

import com.example.maven.pojo.Trainer.Trainer;
import com.example.maven.repository.TtrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class DefaultTrainerService implements TrainerService {

    @Autowired
    private TtrainerRepository ttrainerRepository;

    @Override
    public List<Trainer> findAll()
    {
        return ttrainerRepository.findAll();
    }

    @Override
    public Trainer findOneById(Integer id)
    {
        return ttrainerRepository.findTrainerById(id);
    }

    @Override
    public Trainer create(Integer id, String name, Integer age) {
        Trainer trainer=new Trainer();
        trainer.setId(id);
        trainer.setName(name);
        trainer.setAge(age);
        return ttrainerRepository.save(trainer);
    }

    @Override
    public Trainer edit(Integer id, String name) {
        Trainer trainer=ttrainerRepository.findTrainerById(id);
        if(trainer!=null){
            trainer.setName(name);
            return ttrainerRepository.save(trainer);
        }
        return null;
    }

    @Override
    public void delete(Integer id) {
ttrainerRepository.deleteById(id);
    }
}
