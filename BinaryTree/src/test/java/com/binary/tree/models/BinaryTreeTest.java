package com.binary.tree.models;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BinaryTreeTest {

    @Test
    public void getRoot() {
        BinaryTree<Integer> binaryTree = new BinaryTree<>();
        binaryTree.add(5);
        binaryTree.add(4);

        final int root = binaryTree.getRootNode().getData();

        assertEquals(5, root);
    }

    @Test
    public void add() {
        BinaryTree<Integer> binaryTree = new BinaryTree<>();
        binaryTree.add(5);
        binaryTree.add(6);
        binaryTree.add(4);

        final int root = binaryTree.getRootNode().getData();
        final int leftChild = binaryTree.getRootNode().getLeftNode().getData();
        final int rightChild = binaryTree.getRootNode().getRightNode().getData();

        assertEquals(5, root);
        assertEquals(6, rightChild);
        assertEquals(4, leftChild);
    }

    @Test
    public void remove() {
        BinaryTree<Integer> binaryTree = new BinaryTree<>();
        binaryTree.add(5);
        binaryTree.add(6);
        binaryTree.add(4);

        binaryTree.remove(5);
        final int root = binaryTree.getRootNode().getData();
        final int leftChild = binaryTree.getRootNode().getLeftNode().getData();

        assertEquals(6, root);
        assertEquals(4, leftChild);
    }

    @Test
    public void getMin() {
        BinaryTree<Integer> binaryTree = new BinaryTree<>();
        binaryTree.add(5);
        binaryTree.add(6);
        binaryTree.add(4);

        int min = binaryTree.getMin();

        assertEquals(4, min);
    }

    @Test
    public void getMax() {
        BinaryTree<Integer> binaryTree = new BinaryTree<>();
        binaryTree.add(5);
        binaryTree.add(6);
        binaryTree.add(4);

        int max = binaryTree.getMax();

        assertEquals(6, max);
    }

    @Test
    public void search() {
        BinaryTree<Integer> binaryTree = new BinaryTree<>();
        binaryTree.add(5);
        binaryTree.add(6);
        binaryTree.add(4);

        int search = binaryTree.search(6);

        assertEquals(6, search);
    }
}
