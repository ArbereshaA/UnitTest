package com.example.maven.repository;

import com.example.maven.pojo.Trainer.Trainer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TtrainerRepository extends CrudRepository<Trainer,Integer> {

List<Trainer>findAll();
Trainer findTrainerById(Integer id);
}
