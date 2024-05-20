package com.example.maven.repository;

import com.example.maven.pojo.Equipments.Equipments;
import com.example.maven.pojo.Trainer.Trainer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipmentsRepository  extends CrudRepository<Equipments,Integer> {
    List<Equipments> findAll();
}
