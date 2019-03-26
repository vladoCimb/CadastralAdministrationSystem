
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AVL;

/**
 *
 * @author Vladko
 */
public class Node<T extends Comparable<T>> implements Comparable<AVL.Node<T>> {

    private T data;
    int height , balance;
    Node<T> leftChild, rightChild,parent ;

    Node(T data) {
        this.data = data;
    }
    Node(T data,Node parent) {
        this.data = data;
        this.parent = parent;
    }
    

    public T getData() {
        return data;
    }

    public int getBalanceFactor() {
        return balance;
    }

    public void setBalanceFactor(int balance) {
        this.balance = balance;
    }

    public void setParent(Node<T> parent) {
        this.parent = parent;
    }

    public Node<T> getParent() {
        return parent;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
    
    

    @Override
    public int compareTo(Node<T> node) {
        return this.data.compareTo(node.getData());
    }

    public int getHeight() {
        return height;
    }

    public Node getLeft() {
        return leftChild;
    }

    public Node getRight() {
        return rightChild;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setLeft(Node leftChild) {
        this.leftChild = leftChild;
    }

    public void setRight(Node rightChild) {
        this.rightChild = rightChild;
    }
    
    
}
