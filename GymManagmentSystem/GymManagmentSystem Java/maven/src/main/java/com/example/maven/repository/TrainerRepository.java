package com.example.maven.repository;

import com.example.maven.pojo.Trainer.Trainer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TrainerRepository {
    public ArrayList<Trainer> findAll(){
        return readFromFile();
    }

    public Trainer findOneById(Integer id){
        for (Trainer trainer: readFromFile()){
            if(trainer.getId().equals(id)){
                return trainer;
            }
        }
        return null;
    }
    public Trainer save(Trainer trainer) {
        try {
            FileWriter writer = new FileWriter("trainers.csv", true);
            writer.write(trainer.toCsvString());
            writer.write("\n");
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException();
        }
//        postsInDB.add(post);
        return trainer;
    }
    public Trainer edit(Integer id, String name) {
        ArrayList<Trainer> allTrainers= readFromFile();
        for (Trainer trainer: allTrainers) {
            if (trainer.getId().equals(id)) {
                trainer.setName(name);
                recreateCsvFile(allTrainers);
                return trainer;
            }
        }

        return null;
    }
    public void delete(Integer id){
        ArrayList<Trainer>allTrainers=readFromFile();
        for(Trainer trainer: allTrainers){
            if(trainer.getId().equals(id)){
                allTrainers.remove(trainer);
                recreateCsvFile(allTrainers);
            }
        }
    }
    private void recreateCsvFile(ArrayList<Trainer> allTrainers) {
        try {
            FileWriter writer = new FileWriter("trainers.csv");
            for (Trainer trainer: allTrainers) {
                writer.write(trainer.toCsvString());
                writer.write("\n");
            }
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
    private static ArrayList<Trainer> readFromFile() {
        ArrayList<Trainer> trainers = new ArrayList<>();
        try {
            File file = new File("trainers.csv");
            Scanner reader = new Scanner(file);

            while (reader.hasNext()) {
                String row = reader.nextLine();
                String[] trainerData = row.split(",");
                Trainer trainer = new Trainer
                        (Integer.valueOf(trainerData[0]),
                                trainerData[1],
                                Integer.valueOf(trainerData[2]));

                trainers.add(trainer);
            }

            reader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException();
        }

        return trainers;
    }
}
