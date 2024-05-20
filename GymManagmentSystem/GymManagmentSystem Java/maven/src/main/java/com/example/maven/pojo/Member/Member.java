package com.example.maven.pojo.Member;

import com.example.maven.pojo.Trainer.Trainer;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "member")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "phone")
    private Integer phone;
    @ManyToOne
    @JoinColumn(name = "trainer_id")
    @JsonBackReference
    private Trainer trainer;

    public Member()
    {

    }
    public Member(Integer id, String name, Integer phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }


    public Member(Integer id, String name, Integer phone, Trainer trainer) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.trainer = trainer;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
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

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String toCsvString(){
        return this.id+","+this.name+","+this.phone;
    }
    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", name=" + name + '\'' +
                ", phone=" + phone + '\'' +
                ", trainer=" + trainer +
                '}';
    }
}
