package com.binary.tree.models;

import java.util.Comparator;

public class Node<T extends Comparable<T>> {
    private T data;
    private Node<T> leftNode;
    private Node<T> rightNode;
    private Comparator<T> comparator;

    public Node(final T data, final Comparator<T> comparator) {
        this.data = data;
        this.comparator = comparator;
        this.leftNode = null;
        this.rightNode = null;
    }

    public T getData() {
        return data;
    }

    public Node<T> getLeftNode() {
        return leftNode;
    }

    public Node<T> getRightNode() {
        return rightNode;
    }

    public void setChild(final Node<T> node) {
        if (comparator != null ? comparator.compare(data, node.data) < 0 : data.compareTo(node.data) < 0) {
            if (rightNode == null) {
                rightNode = node;
            } else {
                rightNode.setChild(node);
            }
        } else {
            if (leftNode == null) {
                leftNode = node;
            } else {
                leftNode.setChild(node);
            }
        }
    }

    public Node<T> remove(Node<T> node, final T data) {
        if (node == null) {
            return null;
        }
        if (comparator != null ? comparator.compare(node.data, data) < 0 : node.data.compareTo(data) < 0) {
            node.rightNode = remove(node.rightNode, node.rightNode.data);
        } else if (comparator != null ? comparator.compare(node.data, data) > 0 : node.data.compareTo(data) > 0) {
            node.leftNode = remove(node.leftNode, node.leftNode.data);
        } else {
            if (node.leftNode == null) {
                return node.rightNode;
            } else if (node.rightNode == null) {
                return node.leftNode;
            }
            node.data = node.rightNode.getMin().getData();
            node.rightNode = remove(node.rightNode, node.data);
        }
        return node;
    }

    public Node<T> search(final T obj) {
        if (data.equals(obj)) {
            return this;
        }

        if (comparator != null ? comparator.compare(data, obj) > 0 : data.compareTo(obj) > 0) {
            if (leftNode != null) {
                return leftNode.search(obj);
            } else {
                return null;
            }
        } else if (comparator != null ? comparator.compare(data, obj) < 0 : data.compareTo(obj) < 0) {
            if (rightNode != null) {
                return rightNode.search(obj);
            } else {
                return null;
            }
        }

        return null;
    }

    public Node<T> getMin() {
        return isLeaf() ? this : leftNode != null ? leftNode.getMin() : rightNode.getMin();
    }

    public Node<T> getMax() {
        return isLeaf() ? this : rightNode != null ? rightNode.getMax() : leftNode.getMax();
    }

    public void printInOrder() {
        if (leftNode != null) {
            leftNode.printInOrder();
        }

        System.out.println(data.toString());


        if (rightNode != null) {
            rightNode.printInOrder();
        }
    }

    public void printPostOrder() {
        if (leftNode != null) {
            leftNode.printPostOrder();
        }

        if (rightNode != null) {
            rightNode.printPostOrder();
        }

        System.out.println(data.toString());
    }

    public void printPreOrder() {
        System.out.println(data.toString());

        if (leftNode != null) {
            leftNode.printPreOrder();
        }

        if (rightNode != null) {
            rightNode.printPreOrder();
        }
    }

    private boolean isLeaf() {
        return leftNode == null && rightNode == null;
    }
}
