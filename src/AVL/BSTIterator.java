/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AVL;

import java.util.Stack;

public class BSTIterator<T extends Comparable<T>> {
	Stack<Node> stack;
 
	public BSTIterator(Node root) {
		stack = new Stack<Node>();
		while (root != null) {
			stack.push(root);
			root = root.getLeft();
		}
	}
 
	public boolean hasNext() {
		return !stack.isEmpty();
	}
 
	public Comparable<T> next() {
		Node node = stack.pop();
		Comparable<T> result = node.getData();
		if (node.getRight() != null) {
			node = node.getRight();
			while (node != null) {
				stack.push(node);
				node = node.getLeft();
			}
		}
		return result;
	}
}
