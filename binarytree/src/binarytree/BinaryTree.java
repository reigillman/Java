package binarytree;

import binarytree.BinaryTree.BiNode;
import java.util.Queue;
import java.util.LinkedList;

public class BinaryTree<T> {
	BiNode root=null;
	public BinaryTree(T leftData, T rootdata, T rightData) {
		BiNode<T> left=null;
		BiNode<T> right=null;
		if(leftData !=null) {
			left=new BiNode(null, leftData, null);
		}
		if(rightData !=null) {
			right= new BiNode(null, rightData, null);
		}
		root= new BiNode(left, rootdata, right);
	}
	public BinaryTree(BinaryTree<T> leftChild, T rootData, BinaryTree<T> rightChild) {
		root= new BiNode(rootData);
		if(leftChild !=null) {
			root.setLchild(leftChild.getRoot());
		}
		if(rightChild !=null) {
			root.setRchild(rightChild.getRoot());
		}
	}
	public void setRoot() {
		this.root=root;
	}
	public BiNode getRoot() {
		return root;
	}

	class BiNode<T>{
		T data=null;
		BiNode lchild=null;
		BiNode rchild=null;
		
		BiNode(T rootData){
			data= rootData;
		}
		BiNode(BiNode left, T element, BiNode right){
			lchild=left;
			rchild=right;
			data=element;
		}
		public T getData() {
			return data;
		}
		public void setData(T data) {
			this.data= data;
		}
		public BiNode getLchild() {
			return lchild;
		}
		public void setLchild(BiNode lchild) {
			this.lchild=lchild;
		}
		public BiNode getRchild() {
			return rchild;
		}
		public void setRchild(BiNode rchild) {
			this.rchild=rchild;
		}
	}
	
	public void preorderPrint() {
		preorderPrint(root);
	}
	private void preorderPrint(BiNode<T> tree) {
		if(tree !=null && tree.data !=null) {
			System.out.println(tree.getData().toString() + " ");
			if(tree.lchild !=null) {
				preorderPrint(tree.lchild);
			}
			if(tree.rchild !=null) {
				preorderPrint(tree.rchild);
			}
		}
	}
	public void postorderPrint() {
		postorderPrint(root);
	}
	private void postorderPrint(BiNode<T> tree) {
		if(tree !=null && tree.data !=null) {
			if(tree.lchild !=null) {
				postorderPrint(tree.lchild);
			}
			if(tree.rchild !=null) {
				postorderPrint(tree.rchild);
			}
			System.out.println(tree.getData().toString() + " ");
		}
	}
	public void lvlbylvlPrint() {
		lvlbylvlPrint(root);
	}
	private void lvlbylvlPrint(BiNode<T> tree) {
		Queue<BiNode> myQueue= new LinkedList<BiNode>();
		myQueue.add(root);
		
		while(!myQueue.isEmpty()) {
			BiNode temp= myQueue.poll();
			
			System.out.println(temp.data + " ");
			
			if(temp.lchild!= null) {
				myQueue.add(temp.lchild);
			}
			if(temp.rchild!= null) {
				myQueue.add(temp.rchild);
			}
		}
	}
	public void longestPathPrint() {
		int go= longestPathPrint(root);
		System.out.println(go+1);
	}
	private int longestPathPrint(BiNode<T> tree) {
		if(root== null) {
			return 0;
		}
		if(tree.lchild != null && tree.rchild != null) {
			int left= longestPathPrint(tree.lchild);
			int right= longestPathPrint(tree.rchild);
			return Math.max(left, right) + 1;
		}
		return 0;
	}
}
