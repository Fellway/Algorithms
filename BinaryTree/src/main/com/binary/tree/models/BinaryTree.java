package com.binary.tree.models;

import java.util.Comparator;

public class BinaryTree<T extends Comparable<T>> {
    private Node<T> root;
    private Comparator<T> comparator;

    public BinaryTree() {
    }

    public BinaryTree(final Comparator<T> comparator) {
        this.comparator = comparator;
    }

    public T getRoot() {
        return root.getData();
        System.out.println("Test");
        System.out.println("test2");
    }

    public Node<T> getRootNode() {
        return root;
    }

    public void add(final T obj) {
        if (this.root == null) {
            root = new Node<>(obj, comparator);
        } else {
            root.setChild(new Node<>(obj, comparator));
        }
    }

    public void add(final T... obj) {
        for (T object : obj) {
            if (root == null) {
                root = new Node<>(object, comparator);
            } else {
                root.setChild(new Node<>(object, comparator));
            }
        }
    }

    public void remove(final T obj) {
        Node<T> nodeToRemove = root.search(obj);
        root = root.remove(root, nodeToRemove.getData());
    }

    public T getMin() {
        return root.getMin().getData();
    }

    public T getMax() {
        return root.getMax().getData();
    }

    public void displayTreeInOrder() {
        System.out.println("INORDER");
        if (root != null) {
            root.printInOrder();
        }
    }

    public void displayTreePostOrder() {
        System.out.println("POSTORDER");
        if (root != null) {
            root.printPostOrder();
        }
    }

    public void displayTreePreOrder() {
        System.out.println("PREORDER");
        if (root != null) {
            root.printPreOrder();
        }
    }

    public T search(final T obj) {
        return root.search(obj).getData();
    }

}
