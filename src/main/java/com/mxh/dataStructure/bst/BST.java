package com.mxh.dataStructure.bst;

/**
 * 二分搜索树
 * 
 * @author mxh
 * @version 创建时间：2018年8月20日下午11:27:31 类说明
 */
public class BST<E extends Comparable<E>> {
	// 类型需要可比较性
	private class Node {
		public E e;
		public Node left;
		public Node right;

		public Node(E e) {
			this.e = e;
			left = null;
			right = null;
		}
	}

	private Node root;
	private int size;

	public BST() {
		root = null;
		size = 0;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void add(E e) {
		/*
		 * if (root == null) { root = new Node(e); size++; } else { add(root,
		 * e); }
		 */
		root = add(root, e);
	}

	/**
	 * 向以node为根的二分搜索树中插入E 返回插入新节点后的二分搜索树的根
	 * 
	 * @Last_update 2018年8月20日下午11:43:25
	 * @param node
	 * @param e
	 * @return node
	 */
	private Node add(Node node, E e) {
		/*
		 * if (e.equals(node.e)) { return; } else if (e.compareTo(node.e) > 0 &&
		 * node.left == null) { node.left = new Node(e); size++; } else if
		 * (e.compareTo(node.e) < 0 && node.right == null) { node.right = new
		 * Node(e); size++; }
		 */
		if (node == null) {
			size++;
			return new Node(e);
		}
		if (e.compareTo(node.e) < 0) {
			node.left = add(node.left, e);
		} else if (e.compareTo(node.e) > 0) {
			node.right = add(node.right, e);
		}
		return node;
	}

	public boolean contains(E e) {
		return contains(root, e);
	}

	/*
	 * 看以node为根的二分搜索树种是否包含元素e
	 */
	private boolean contains(Node node, E e) {
		if (node == null) {
			return false;
		}
		if (e.compareTo(node.e) == 0) {
			return true;
		} else if (e.compareTo(node.e) < 0) {
			return contains(node.left, e);
		} else {
			return contains(node.right, e);
		}
	}

	/*
	 * 前序遍历
	 */
	public void preOrder() {
		preOrder(root);
	}

	private void preOrder(Node node) {
		if (node == null) {
			return;
		}
		System.out.println(node.e);
		preOrder(node.left);
		preOrder(node.right);
	}

	public String toString() {
		StringBuilder res = new StringBuilder();
		generaBSTString(root, 0, res);
		return res.toString();
	}

	private void generaBSTString(Node node, int depth, StringBuilder res) {
		if (node == null) {
			res.append(generaDepth(depth) + "null\n");
			return;
		}
		res.append(generaDepth(depth) + node.e + "\n");
		generaBSTString(node.left, depth + 1, res);
		generaBSTString(node.right, depth + 1, res);
	}

	private String generaDepth(int depth) {
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < depth; i++) {
			res.append("==");
		}
		return res.toString();
	}

	public void inOrder() {
		inOrder(root);
	}

	private void inOrder(Node node) {
		if (node == null) {
			return;
		}
		inOrder(node.left);
		System.out.println(node.e);
		inOrder(node.right);
	}

	public void postOrder() {
		postOrder(root);
	}

	private void postOrder(Node node) {
		if (node == null) {
			return;
		}
		postOrder(node.left);
		postOrder(node.right);
		System.out.println(node.e);
	}
}
