package com.example.maven.pojo.Member;

public class CreateMemberInput {
    private Integer id;
    private String name;
    private Integer phone;
    private Integer trainerId;

    public CreateMemberInput() {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.trainerId = trainerId;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(Integer trainerId) {
        this.trainerId = trainerId;
    }
}
