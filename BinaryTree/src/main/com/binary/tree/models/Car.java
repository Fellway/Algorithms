package com.binary.tree.models;

import com.binary.tree.models.enums.Color;

public class Car implements Comparable<Car> {
    private String model;
    private Color color;
    private Integer maxSpeed;
    private Integer doors;

    public Car() {
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Integer getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(Integer maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public Integer getDoors() {
        return doors;
    }

    public void setDoors(Integer doors) {
        this.doors = doors;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", color=" + color +
                ", maxSpeed=" + maxSpeed +
                ", doors=" + doors +
                '}';
    }

    @Override
    public int compareTo(Car car) {
        int result = Integer.compare(maxSpeed, car.maxSpeed);
        if (result == 0) {
            result = Integer.compare(doors, car.doors);
        }
        return result;
    }
}
