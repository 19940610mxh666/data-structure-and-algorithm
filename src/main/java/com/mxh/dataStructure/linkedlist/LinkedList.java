package com.mxh.dataStructure.linkedlist;

/**
 * 链表
 * 
 * @author mxh
 * @version 创建时间：2018年8月18日上午1:04:20 类说明
 */
public class LinkedList<E> {

	private class Node {
		public E e;
		public Node next;

		public Node(E e, Node next) {
			this.e = e;
			this.next = next;
		}

		public Node(E e) {
			this(e, null);
		}

		public Node() {
			this(null, null);
		}

		public String toString() {
			return e.toString();
		}
	}

	private Node dummyHead;
	int size;

	public LinkedList() {
		dummyHead = new Node(null, null);
		size = 0;
	}

	public int getSize() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void addFirst(E e) {
		// 一样的效果
		/*
		 * Node node = new Node(e); node.next=head; head=node;
		 */
		add(0, e);
	}

	// 通过索引添加元素
	public void add(int index, E e) {
		if (index < 0 || index > size) {
			throw new IllegalArgumentException("failed.illegal index");
		}
		Node prev = dummyHead;
		for (int i = 0; i < index; i++) {
			prev = prev.next;
		}
		prev.next = new Node(e, prev.next);
		size++;

	}

	public E get(int index) {
		if (index < 0 || index >= size) {
			throw new IllegalArgumentException("illegal index");
		}
		Node cur = dummyHead.next;
		for (int i = 0; i < index; i++) {
			cur = cur.next;
		}
		return cur.e;
	}

	public E getLast() {
		return get(size - 1);
	}
	public E getFirst(){
		return get(0);
	}

	public void set(int index, E e) {
		if (index < 0 || index >= size) {
			throw new IllegalArgumentException("illegal index");
		}
		Node cur = dummyHead.next;
		for (int i = 0; i < index++; i++) {
			cur = cur.next;
		}
		cur.e = e;
	}

	public boolean contains(E e) {
		Node cur = dummyHead.next;
		while (cur != null) {
			if (cur.e.equals(e)) {
				return true;
			}
			cur = cur.next;
		}
		return false;
	}

	public String toString() {
		StringBuilder res = new StringBuilder();
		Node cur = dummyHead.next;
		while (cur != null) {
			res.append(cur + "->");
			cur = cur.next;
		}
		res.append("Null");
		return res.toString();
	}

	public E remove(int index) {
		if (index < 0 || index >= size) {
			throw new IllegalArgumentException("illegal index");
		}
		Node prev = dummyHead;
		for (int i = 0; i < index; i++) {
			prev = prev.next;
		}
		Node resNode = prev.next;
		prev.next = resNode.next;
		resNode.next = null;
		size--;
		return resNode.e;
	}

	public E removeFirst() {
		return remove(0);
	}

	public E removerLast() {
		return remove(size - 1);
	}
}
