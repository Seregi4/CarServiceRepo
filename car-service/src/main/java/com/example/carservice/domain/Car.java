package com.example.carservice.domain;

import lombok.*;


import javax.persistence.*;


@Data
@NoArgsConstructor
@Entity
@Table(name = "carlist")
public class Car {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column(name = "name")
    private String name;
    @NonNull
    @Column(name = "color")
    private String color;

    public Car(String name,String color) {
        this.name = name;
        this.color = color;
    }


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
