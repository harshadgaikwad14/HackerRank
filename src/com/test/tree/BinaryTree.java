package com.test.tree;

public class BinaryTree {

	Node root;

	public BinaryTree(int item) {

		root = new Node(item);
	}

	BinaryTree() {
		root = null;
	}

	public static void main(String[] args) {
		
		BinaryTree tree = new BinaryTree(); 
		  
        /*create root*/
        tree.root = new Node(1); 
        
        System.out.println(tree);
        
        tree.root.left = new Node(2);
        System.out.println(tree);
        tree.root.right = new Node(3);
        System.out.println(tree);
        tree.root.left.left = new Node(4);
        System.out.println(tree);

	}

	@Override
	public String toString() {
		return "BinaryTree [root=" + root + "]";
	}

	
}
