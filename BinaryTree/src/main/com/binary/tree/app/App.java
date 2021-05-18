package com.binary.tree.app;

import com.binary.tree.models.BinaryTree;
import com.binary.tree.models.Car;
import com.binary.tree.utils.BSTCarGenerator;

import java.util.Comparator;

public class App {
    public static void main(String[] args) {
        BSTCarGenerator generator = new BSTCarGenerator();
        BinaryTree<Car> binaryTree = generator.generateBinaryTree(20);
        binaryTree.displayTreePostOrder();
        System.out.println();
        binaryTree.displayTreeInOrder();
        System.out.println();

        BinaryTree<Car> removeExample = new BinaryTree<>();
        Car carToRemove = BSTCarGenerator.generateCar();
        removeExample.add(carToRemove);
        removeExample.add(BSTCarGenerator.generateCar());
        removeExample.add(BSTCarGenerator.generateCar());
        removeExample.displayTreePostOrder();
        removeExample.remove(carToRemove);
        System.out.println();
        removeExample.displayTreePostOrder();
        System.out.println();

        Comparator<Integer> comparator = Comparator.reverseOrder();
        BinaryTree<Integer> comparatorExample = new BinaryTree<>(comparator);
        comparatorExample.add(1);
        comparatorExample.add(4);
        comparatorExample.add(5);
        comparatorExample.add(2);
        comparatorExample.add(9);
        comparatorExample.add(3);
        System.out.println("Reverse order comparator");
        comparatorExample.displayTreeInOrder();
        System.out.println();

//      Example model with solution -> https://www.cdn.geeksforgeeks.org/wp-content/uploads/Preorder-from-Inorder-and-Postorder-traversals.jpg
        BinaryTree<Integer> example = new BinaryTree<>();
        example.add(25, 15, 50, 10, 22, 35, 70, 4, 12, 18, 24, 31, 44, 66, 90);
        example.displayTreeInOrder();
        example.displayTreePreOrder();
        example.displayTreePostOrder();
        System.out.println("Root: " + example.getRoot());
    }
}
