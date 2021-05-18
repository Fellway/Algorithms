package com.binary.tree.utils;

import com.binary.tree.models.BinaryTree;
import com.binary.tree.models.Car;
import com.binary.tree.models.enums.Color;

import java.util.Random;
import java.util.UUID;

public class BSTCarGenerator {
    public BinaryTree<Car> generateBinaryTree(final Integer treeNodesNumber) {
        BinaryTree<Car> binaryTree = new BinaryTree<>();

        for (int i = 0; i < treeNodesNumber; i++) {
            binaryTree.add(generateCar());
        }

        return binaryTree;
    }

    public static Car generateCar() {
        Car car = new Car();
        car.setColor(Color.getRandomColor());
        car.setDoors(5);
        car.setMaxSpeed(new Random().nextInt(250));
        car.setModel(UUID.randomUUID().toString());
        return car;
    }
}
