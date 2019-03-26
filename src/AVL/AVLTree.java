/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AVL;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import mainpackage.Logika;

/**
 *
 * @author Vladko
 */
public class AVLTree<T extends Comparable<T>> {

    private Node<T> root;
    private int size = 0;

    public AVLTree() {
        root = null;
    }

    private enum typeOfChild {
        LEFT, RIGHT
    }

    public boolean insert(T data) {
        if (root == null) {
            this.root = new Node<T>(data);
        } else {

            // AVL strom je maximálne o 45% vyšší, ako dokonale vývážený strom.
            int worstCase = this.size / 2 + 1;

            Node<T>[] parents = new Node[worstCase];
            typeOfChild[] childTypes = new typeOfChild[worstCase];

            int parentCount = 0;
            Node<T> current = root;

            //Hľadananie umiestnenia
            while (current != null) {
                int comp = data.compareTo(current.getData());
                if (comp == 0) {
                    return false;
                } else {
                    parents[parentCount] = current;
                    if (comp < 0) {
                        current = current.getLeft();
                        childTypes[parentCount] = typeOfChild.LEFT;
                    } else {
                        current = current.getRight();
                        childTypes[parentCount] = typeOfChild.RIGHT;
                    }
                    parentCount++;
                }
            }

            //Vloženie vrcholu
            current = parents[parentCount - 1];
            if (childTypes[parentCount - 1] == typeOfChild.LEFT) {
                Node<T> newNode = new Node<T>(data);
                newNode.setParent(current);
                current.setLeft(newNode);
            } else {
                Node<T> newNode = new Node<T>(data);
                newNode.setParent(current);
                current.setRight(newNode);
            }

            //Prechádzanie všetkych rodičov po ceste a aktualizovanie výšky a balance faktoru
            for (int i = parentCount - 1; i > 0; i--) {
                current = parents[i];
                this.updateFactorAndHeight(current);
                this.rebalance(current, parents[i - 1], childTypes[i - 1]);
            }

            //akutalizovanie korena
            this.updateFactorAndHeight(this.root);
            this.rebalance(this.root, null, null);
        }
        this.size++;
        return true;
    }

    private void updateFactorAndHeight(Node<T> target) {
        Node<T> left = target.getLeft();
        Node<T> right = target.getRight();

        //Výpočet balance faktoru
        int numLeft = (left == null ? -1 : left.getHeight());
        int numRight = (right == null ? -1 : right.getHeight());
        target.setBalanceFactor(numLeft - numRight);

        numLeft = (left == null ? -1 : left.getHeight());
        numRight = (right == null ? -1 : right.getHeight());
        target.setHeight(Math.max(numLeft, numRight) + 1);
    }

    private void rebalance(Node<T> target, Node<T> parent, typeOfChild type) {
        int balanceFactor = target.getBalanceFactor();

        //Ak je ľavý podstrom väčši ako pravý
        if (balanceFactor > 1) {

            //(L->R)
            if (target.getLeft().getBalanceFactor() < 0) {
                this.rotateLeft(target.getLeft(), target, typeOfChild.LEFT);
            }
            this.rotateRight(target, parent, type);

            //Ak je pravý podstram väčši ako ľavý
        } else if (balanceFactor < -1) {
            // (R-L)
            if (target.getRight().getBalanceFactor() > 0) {
                rotateRight(target.getRight(), target, typeOfChild.RIGHT);
            }

            this.rotateLeft(target, parent, type);
        }
    }

    private void rotateRight(Node<T> target, Node<T> parent, typeOfChild type) {
        Node<T> pivot = target.getLeft();

        //Pravá rotácia
        target.setLeft(pivot.getRight());
        if(pivot.getRight()!= null){
            pivot.getRight().setParent(target);
        }
        pivot.setParent(target.parent);
        pivot.setRight(target);
        target.setParent(pivot);

        //Nastavenie rodičov
        if (parent == null) {
            this.root = pivot;
        } else if (type == typeOfChild.LEFT) {
            parent.setLeft(pivot);
            pivot.setParent(parent);
        } else {
            parent.setRight(pivot);
            pivot.setParent(parent);
        }

        //Aktualizovanie výšok a balance faktoru
        this.updateFactorAndHeight(target);
        this.updateFactorAndHeight(pivot);
    }

    private void rotateLeft(Node<T> target, Node<T> parent, typeOfChild type) {
        Node<T> pivot = target.getRight();

        //Lavá rotácia
        target.setRight(pivot.getLeft());
        if (pivot.getLeft() != null) {
            pivot.getLeft().setParent(target);
        }
        pivot.setParent(target.parent);
        pivot.setLeft(target);
        target.setParent(pivot);

        //Nastavenie rodičov
        if (parent == null) {
            this.root = pivot;
        } else if (type == typeOfChild.LEFT) {
            parent.setLeft(pivot);
            pivot.setParent(parent);
        } else {
            parent.setRight(pivot);
            pivot.setParent(parent);
        }

        //Aktualizovanie výšok a balance faktoru
        this.updateFactorAndHeight(target);
        this.updateFactorAndHeight(pivot);
    }

    public T deleteT(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Argument cannot be null!");
        } else if (size == 0) {
            return null;
        }

        // AVL strom je maximálne o 45% vyšší, ako dokonale vývážený strom.
        int worstCase = this.size / 2 + 1;

        Node<T>[] parents = new Node[worstCase];
        typeOfChild[] childTypes = new typeOfChild[worstCase];

        int parentCount = 0;
        Node<T> current = root;
        int comp;

        do {
            comp = data.compareTo(current.getData());
            parents[parentCount] = current;
            if (comp == 0) {
                break;
            }
            if (comp < 0) {
                current = current.getLeft();
                childTypes[parentCount] = typeOfChild.LEFT;
            } else {
                current = current.getRight();
                childTypes[parentCount] = typeOfChild.RIGHT;
            }
            parentCount++;
        } while (current != null && comp != 0);

        //Mazaný prvok neexistuje
        if (current == null) {
            return null;
        }

        //Uloženie dát na return
        T result = current.getData();

        Node<T> left = current.getLeft();
        Node<T> right = current.getRight();

        //3 prípady
        //1. nemá pravého ani ľavého syna
        if (left == null && right == null) {
            if (parentCount > 0) {
                Node<T> parent = parents[parentCount - 1];
                if (childTypes[parentCount - 1] == typeOfChild.LEFT) {
                    parent.setLeft(null);
                } else {
                    parent.setRight(null);
                }
            } else {
                this.root = null;
            }
            //2. má jedného syna
        } else if (left == null || right == null) {
            Node<T> loneChild = (left == null ? right : left);

            if (parentCount > 1) {
                Node<T> parent = parents[parentCount - 1];
                if (childTypes[parentCount - 2] == typeOfChild.LEFT) {
                    parent.setLeft(loneChild);
                } else {
                    parent.setRight(loneChild);
                }
            } else {
                this.root = loneChild;
            }
            //má oboch synov
        } else {
            Node<T> successor = right;
            Node<T> successorParent = current;
            typeOfChild type = typeOfChild.RIGHT;
            while (successor.getLeft() != null) {
                successorParent = successor;
                parents[parentCount++] = successorParent;
                successor = successor.getLeft();
                type = typeOfChild.LEFT;
            }

            current.setData(successor.getData());

            if (type == typeOfChild.RIGHT) {
                successorParent.setRight(null);
            } else {
                successorParent.setLeft(null);
            }
        }

        for (int i = parentCount - 1; i > 0; i--) {
            current = parents[i];
            this.updateFactorAndHeight(current);
            this.rebalance(current, parents[i - 1], childTypes[i - 1]);
        }

        if (parentCount > 0) {
            this.updateFactorAndHeight(this.root);
            this.rebalance(this.root, null, null);
        }

        size--;

        return result;
    }

    public void delete(T data) {
        if (findNode(data) != null) {
            delete(findNode(data));
        }

    }

    private void delete(Node<T> node) {
        if (node.leftChild == null && node.rightChild == null) {
            if (node.parent == null) {
                root = null;
            } else {
                Node<T> parent = node.parent;
                if (parent.leftChild == node) {
                    parent.leftChild = null;
                } else {
                    parent.rightChild = null;
                }
                rebalance(parent);
            }
            return;
        }

        if (node.leftChild != null) {
            Node<T> child = node.leftChild;
            while (child.rightChild != null) {
                child = child.rightChild;
            }
            node.setData(child.getData());
            delete(child);
        } else {
            Node<T> child = node.rightChild;
            while (child.leftChild != null) {
                child = child.leftChild;
            }
            node.setData(child.getData());
            delete(child);
        }
    }

    public Node<T> findNode(T data) {
        Node<T> newNode = new Node<T>(data);
        if (root == null) {
            return null;
        }

        Node<T> child = root;
        while (child != null) {
            Node<T> node = child;

            child = newNode.compareTo(node) >= 0 ? node.rightChild : node.leftChild;
            if (newNode.compareTo(node) == 0) {
                return node;
            }
        }
        return null;
    }

    private void rebalance(Node<T> n) {
        setBalance(n);

        if (n.balance == +2) {
            if (height(n.leftChild.leftChild) >= height(n.leftChild.rightChild)) {
                n = rotateRight(n);
            } else {
                n = rotateLeftThenRight(n);
            }

        } else if (n.balance == -2) {
            if (height(n.rightChild.rightChild) >= height(n.rightChild.leftChild)) {
                n = rotateLeft(n);
            } else {
                n = rotateRightThenLeft(n);
            }
        }

        if (n.parent != null) {
            rebalance(n.parent);
        } else {
            root = n;
        }
    }

    private Node rotateLeft(Node<T> a) {

        Node b = a.rightChild;
        b.parent = a.parent;

        a.rightChild = b.leftChild;

        if (a.rightChild != null) {
            a.rightChild.parent = a;
        }

        b.leftChild = a;
        a.parent = b;

        if (b.parent != null) {
            if (b.parent.rightChild == a) {
                b.parent.rightChild = b;
            } else {
                b.parent.leftChild = b;
            }
        }

        setBalance(a, b);

        return b;
    }

    private Node rotateRight(Node<T> a) {

        Node b = a.leftChild;
        b.parent = a.parent;

        a.leftChild = b.rightChild;

        if (a.leftChild != null) {
            a.leftChild.parent = a;
        }

        b.rightChild = a;
        a.parent = b;

        if (b.parent != null) {
            if (b.parent.rightChild == a) {
                b.parent.rightChild = b;
            } else {
                b.parent.leftChild = b;
            }
        }

        setBalance(a, b);

        return b;
    }

    public Node<T> getRoot() {
        return root;
    }

    private Node rotateLeftThenRight(Node<T> n) {
        n.leftChild = rotateLeft(n.leftChild);
        return rotateRight(n);
    }

    private Node rotateRightThenLeft(Node<T> n) {
        n.rightChild = rotateRight(n.rightChild);
        return rotateLeft(n);
    }

    private int height(Node<T> n) {
        if (n == null) {
            return -1;
        }
        return n.height;
    }

    private void setBalance(Node... nodes) {
        for (Node n : nodes) {
            reheight(n);
            n.balance = height(n.leftChild) - height(n.rightChild);
        }
    }

    private void reheight(Node<T> node) {
        if (node != null) {
            node.height = 1 + Math.max(height(node.leftChild), height(node.rightChild));
        }
    }

    public ArrayList<Comparable<T>> inOrderTraverseTreeArray(Node focusNode, ArrayList<Comparable<T>> returnList) {
        if (returnList == null) {
            returnList = new ArrayList<Comparable<T>>();
        }
        if (focusNode != null) {
            inOrderTraverseTreeArray(focusNode.leftChild, returnList);
            System.out.println(focusNode.getData());
            returnList.add(focusNode.getData());
            inOrderTraverseTreeArray(focusNode.rightChild, returnList);
        }
        return returnList;
    }

    public void inOrderTraverseTree(Node focusNode) {

        if (focusNode != null) {
            inOrderTraverseTree(focusNode.leftChild);
            System.out.println(focusNode.getData());
            inOrderTraverseTree(focusNode.rightChild);
        }
    }

    public void preOrderTraverseTree(Node<T> focusNode) {
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

    public ArrayList<T> makeTreeToArrayList() {
        ArrayList<T> arrayListReturn = new ArrayList<T>();
        Node<T> node = this.root;
        if (node != null) {
            System.out.println(node.getData().toString());
            while (node != null) {
                arrayListReturn.add(node.getData());
                node = this.getInOrderFollower(node);
            }
        }

        return arrayListReturn;
    }

    public Node<T> getInOrderFollower(Node<T> node) {
        return null;
    }

    ///////////// Vypis stromu
    public void printNode(Node<T> root) {
        int maxLevel = maxLevel(root);
        printNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    private int maxLevel(Node<T> node) {
        if (node == null) {
            return 0;
        }

        return Math.max(maxLevel(node.leftChild), maxLevel(node.rightChild)) + 1;
    }

    private void printNodeInternal(List<Node<T>> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || isAllElementsNull(nodes)) {
            return;
        }

        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        printWhitespaces(firstSpaces);

        List<Node<T>> newNodes = new ArrayList<Node<T>>();
        for (Node<T> node : nodes) {
            if (node != null) {
                System.out.print(node.getData().toString());
                newNodes.add(node.leftChild);
                newNodes.add(node.rightChild);
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }

            printWhitespaces(betweenSpaces);
        }
        System.out.println("");

        for (int i = 1; i <= endgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                printWhitespaces(firstSpaces - i);
                if (nodes.get(j) == null) {
                    printWhitespaces(endgeLines + endgeLines + i + 1);
                    continue;
                }

                if (nodes.get(j).leftChild != null) {
                    System.out.print("/");
                } else {
                    printWhitespaces(1);
                }

                printWhitespaces(i + i - 1);

                if (nodes.get(j).rightChild != null) {
                    System.out.print("\\");
                } else {
                    printWhitespaces(1);
                }

                printWhitespaces(endgeLines + endgeLines - i);
            }

            System.out.println("");
        }

        printNodeInternal(newNodes, level + 1, maxLevel);
    }

    private void printWhitespaces(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(" ");
        }
    }

    private boolean isAllElementsNull(List<Node<T>> list) {
        for (Object object : list) {
            if (object != null) {
                return false;
            }
        }

        return true;
    }

}
