package com.mxh.dataStructure.bst;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * ����������
 * 
 * @author mxh
 * @version ����ʱ�䣺2018��8��20������11:27:31 ��˵��
 */
public class BST<E extends Comparable<E>> {
	// ������Ҫ�ɱȽ���
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
	 * ����nodeΪ���Ķ����������в���E ���ز����½ڵ��Ķ����������ĸ�
	 * 
	 * @Last_update 2018��8��20������11:43:25
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
	 * ����nodeΪ���Ķ������������Ƿ����Ԫ��e
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
	 * ǰ�����
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

	// �ǵݹ�ǰ�����
	public void preOrderNR() {
		Stack<Node> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			Node cur = stack.pop();
			System.out.println(cur.e);
			if (cur.right != null) {
				stack.push(cur.right);
			}
			if (cur.left != null) {
				stack.push(cur.left);
			}
		}
	}

	// �������
	public void levelOrder() {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while (!queue.isEmpty()) {
			Node cur = queue.remove();
			System.out.println(cur.e);
			if (cur.left != null) {
				queue.add(cur.left);
			}
			if (cur.right != null) {
				queue.add(cur.right);
			}
		}
	}

	// Ѱ����Сֵ
	public E minimum() {
		if (size == 0) {
			throw new IllegalArgumentException("BST is empty");
		}
		return minimum(root).e;
	}

	private Node minimum(Node node) {
		if (node.left == null) {
			return node;
		}
		return minimum(node.left);
	}

	// Ѱ�����ֵ
	public E minimax() {
		if (size == 0) {
			throw new IllegalArgumentException("BST is empty");
		}
		return minimax(root).e;
	}

	private Node minimax(Node node) {
		if (node.right == null) {
			return node;
		}
		return minimum(node.left);
	}

	// ɾ����������Сֵ
	public E removeMin() {
		E ret = minimum();
		root = removeMin(root);
		return ret;
	}

	private Node removeMin(Node node) {
		if (node.left == null) {
			Node rightNode = node.right;
			node.right = null;
			size--;
			return rightNode;
		}
		node.left = removeMin(node.left);
		return node;
	}

	// ɾ�����������ֵ
	public E removeMax() {
		E ret = minimax();
		root = removeMax(root);
		return ret;
	}

	private Node removeMax(Node node) {
		if (node.right == null) {
			Node leftNode = node.left;
			node.left = null;
			size--;
			return leftNode;
		}
		node.right = removeMin(node.right);
		return node;
	}

	public void remove(E e) {
		root = remove(root, e);
	}

	private Node remove(Node node, E e) {
		if (node == null) {
			return null;
		}
		if (e.compareTo(node.e) < 0) {
			node.left = remove(node.left, e);
			return node;
		} else if (e.compareTo(node.e) > 0) {
			node.right = remove(node.right, e);
			return node;
		} else {
			if (node.left == null) {
				Node rightNode = node.right;
				node.right = null;
				size--;
				return rightNode;
			}
			if (node.right == null) {
				Node leftNode = node.left;
				node.left = null;
				size--;
				return leftNode;
			}
			// ������������Ϊ�գ�Ѱ�Һ��
			Node successor = minimum(node.right);
			successor.right = removeMin(node.right);
			successor.left = node.left;
			node.left = node.right = null;
			return successor;
		}
	}
}
