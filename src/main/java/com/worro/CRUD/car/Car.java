package com.worro.CRUD.car;

import jakarta.persistence.*;
import org.springframework.context.annotation.Primary;


@Entity
@Table
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String carName;

    @Column
    private String type;

    public long getId() {
        return id;
    }

    public String getCarName() {
        return carName;
    }

    public String getType() {
        return type;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Car(long id, String carName, String type) {
        this.id = id;
        this.carName = carName;
        this.type = type;
    }

    public Car() {
    }
}
