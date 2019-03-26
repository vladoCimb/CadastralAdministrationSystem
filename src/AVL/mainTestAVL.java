/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AVL;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Vladko
 */
public class mainTestAVL<T extends Comparable<T>> {

    AVLTree tree = new AVLTree();

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        /* Constructing tree given in the above figure */
 /*
        System.out.println("Inserting values 1 to 10");
        for (int i = 1; i < 10; i++)
            tree.insert(i);
         */
 /*
        Random rnd = new Random();
        int cislo;
        int operacia;
        int vlozenych = 0;
        int deletnutych = 0;
        for (int i = 0; i < 10000; i++) {
            operacia = rnd.nextInt(2);
            cislo = rnd.nextInt(10000);
            if(operacia == 0){
                tree.insert(cislo);
            } else {
                tree.delete(cislo);
            }
        }
         */
 /*
        tree.insert(186);
        tree.insert(256);
        tree.insert(586);
        
        tree.delete(586);
         */
        //tree.insert(22);

        /*
        tree.insert(17);
        tree.insert(12);
        tree.insert(21);
        tree.insert(10);
        tree.insert(15);
        tree.insert(19);
        tree.insert(27);
        tree.insert(14);
        tree.insert(28);
        tree.insert(36);
        tree.insert(77);
        tree.insert(2);
        tree.insert(7);
        tree.insert(1);
         */
        //tree.printNode(tree.getRoot());
        //ArrayList list = tree.inOrderTraverseTreeArray(tree.getRoot(), null);
        //tree.preOrderTraverseTree(tree.getRoot());
    }

    /* The constructed AVL Tree would be 
             30 
            /  \ 
          20   40 
         /  \     \ 
        10  25    50 
     */
}
