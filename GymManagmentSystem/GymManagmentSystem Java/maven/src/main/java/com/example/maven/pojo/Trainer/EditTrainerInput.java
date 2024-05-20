package com.example.maven.pojo.Trainer;

public class EditTrainerInput {
    private String name;

    public EditTrainerInput(){

    }

    public EditTrainerInput(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
