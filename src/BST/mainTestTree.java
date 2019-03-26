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
public class mainTestTree {
    public static void main(String[] args){
        BinaryTree theTree = new BinaryTree();
        theTree.addNode(50);
        theTree.addNode(65);
        theTree.preOrderTraverseTree(theTree.root);
        theTree.removeNode(65);
        theTree.preOrderTraverseTree(theTree.root);

      
        
    }
}
