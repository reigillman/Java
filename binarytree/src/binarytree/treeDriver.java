package binarytree;

import binarytree.BinaryTree.BiNode;

public class treeDriver {
	public static void main(String[] args) {
		BinaryTree<String> t1= new BinaryTree<String>("7", "&", "0");
		BinaryTree<String> t2= new BinaryTree<String>("9", "*", "6");
		BinaryTree<String> t3= new BinaryTree<String>(t1, "-", t2);
		/**
		System.out.println("postorder:");
		t3.postorderPrint();
		System.out.println("");
		System.out.println("preorder:");
		t3.preorderPrint();
		System.out.println("");
		System.out.println("level by level:");
		t3.lvlbylvlPrint();
		**/
		BinaryTree<String> s1= new BinaryTree<String>("4", "*", null);
		BinaryTree<String> s2= new BinaryTree<String>("7", "&", "13");
		BinaryTree<String> s3= new BinaryTree<String>(s1, "+", s2);
		BinaryTree<String> s4= new BinaryTree<String>("4", "=", "6");
		BinaryTree<String> s5= new BinaryTree<String>(s4, "#", s3); 
		
		BinaryTree<String> u0= new BinaryTree<String>("2", "%", "0");
		BinaryTree<String> u1= new BinaryTree<String>("6", "^", "7");
		BinaryTree<String> u2= new BinaryTree<String>(null, "*", "3");
		BinaryTree<String> u3= new BinaryTree<String>(u1, "@", u0);
		BinaryTree<String> u4= new BinaryTree<String>(u3, "^", u2);
		BinaryTree<String> u5= new BinaryTree<String>("9", "#", "6"); 
		BinaryTree<String> u6= new BinaryTree<String>(u4, "-", u5); 
		System.out.println("Longest path: ");
		s5.longestPathPrint();
		
		System.out.println("Longest path: ");
		t3.longestPathPrint();
		
		System.out.println("Longest path: ");
		u6.longestPathPrint();
	}

}
