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
public class BinaryTree<T extends Comparable<T>> {

    Node<T> root;

    public BinaryTree() {
        root = null;
    }
    
    
    public void addNode(T value) {
        Node<T> newNode = new Node<T>(value);
        if (root == null) {
            root = newNode;
        } else {
            Node focusNode = root;
            Node parent;
            while (true) {
                parent = focusNode;
                if (newNode.compareTo(focusNode) < 0 ) {
                    focusNode = focusNode.leftChild;
                    if (focusNode == null) {
                        parent.leftChild = newNode;
                        return;
                    }
                } else {
                    focusNode = focusNode.rightChild;
                    if (focusNode == null) {
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }

    }
    
    public Node findNode(T value) {
        Node<T> focusNode = root;
        Node<T> newNode = new Node<T>(value);

        while (focusNode.compareTo(newNode) != 0) {
            if (newNode.compareTo(focusNode) < 0) {
                focusNode = focusNode.leftChild;
            } else {
                focusNode = focusNode.rightChild;
            }
            if (focusNode == null) {
                return null;
            }
        }
        return focusNode;
    }
    
     public void inOrderTraverseTree(Node focusNode) {
        if (focusNode != null) {
            inOrderTraverseTree(focusNode.leftChild);
            System.out.println(focusNode.getData());
            inOrderTraverseTree(focusNode.rightChild);
        }
    }

    public void preOrderTraverseTree(Node focusNode) {
        if (focusNode != null) {
            System.out.println(focusNode.getData());
            preOrderTraverseTree(focusNode.leftChild);
            preOrderTraverseTree(focusNode.rightChild);
        }
    }

    public void postOrderTraverseTree(Node focusNode) {
        if (focusNode != null) {
            postOrderTraverseTree(focusNode.leftChild);
            postOrderTraverseTree(focusNode.rightChild);
            System.out.println(focusNode.getData());
        }
    }
    
    public boolean removeNode(T value) {
        Node<T> focusNode = root;
        Node<T> newNode = new Node<T>(value);
        Node<T> parent = root;

        boolean isLeftChild = true;
        while (focusNode.compareTo(newNode) != 0) {
            parent = focusNode;
            if (newNode.compareTo(focusNode) < 0) {
                isLeftChild = true;
                focusNode = focusNode.leftChild;

            } else {
                isLeftChild = false;
                focusNode = focusNode.rightChild;
            }
            if (focusNode == null) {
                return false;
            }
        }
        if (focusNode.leftChild == null && focusNode.rightChild == null) {
            if (focusNode == root) {
                root = null;
            } else if (isLeftChild) {
                parent.leftChild = null;
            } else {
                parent.rightChild = null;
            }
        } else if (focusNode.rightChild == null) {
            if (focusNode == root) {
                root = focusNode.leftChild;
            } else if (isLeftChild) {
                parent.leftChild = focusNode.leftChild;
            } else {
                parent.rightChild = focusNode.leftChild;
            }

        } else if (focusNode.leftChild == null) {
            if (focusNode == root) {
                root = focusNode.rightChild;
            } else if (isLeftChild) {
                parent.leftChild = focusNode.rightChild;
            } else {
                parent.rightChild = focusNode.rightChild;
            }
        } else {
            Node replacment = getReplacementNode(focusNode);
            if (focusNode == root) {
                root = replacment;
            } else if (isLeftChild) {
                parent.leftChild = replacment;
            } else {
                parent.rightChild = replacment;
            }
            replacment.leftChild = focusNode.leftChild;

        }
        return true;
    }
    
    private Node getReplacementNode(Node replacedNode) {
        Node replacementParent = replacedNode;
        Node replacement = replacedNode;
        Node focusNode = replacedNode.rightChild;
        while(focusNode != null){
            replacementParent = replacement;
            replacement = focusNode;
            focusNode = focusNode.leftChild;
        }
        if(replacement != replacedNode.rightChild){
            replacementParent.leftChild = replacement.rightChild;
            replacement.rightChild = replacedNode.rightChild;
        }
        return replacement;
    }
    

}
