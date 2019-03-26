/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BST;

/**
 *
 * @author Vladko
 */
public class Node<T extends Comparable<T>> implements Comparable<Node<T>> {

    private T data;
    Node leftChild,rightChild;

    public Node(T data) {
        this.data = data;
    }

    @Override
    public int compareTo(Node<T> node) {
        return this.data.compareTo(node.getData());
    }

    public Node(T data, Node leftChild, Node rightChild) {
        this.data = data;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public T getData() {
        return data;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setValue(T data) {
        this.data = data;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

}
