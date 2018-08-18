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

	private Node head;
	int size;

	public LinkedList() {
		head = null;
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
		head = new Node(e, head);
		size++;
	}

	// 通过索引添加元素
	public void add(int index, E e) {
		if (index < 0 || index > size) {
			throw new IllegalArgumentException("failed.illegal index");
		}
		if (index == 0) {
			addFirst(e);
		} else {
			Node prev = head;
			for (int i = 0; i < index-1; i++) {
				prev = prev.next;
			}
			prev.next = new Node(e, prev.next);
			size++;
		}
	}
	

}
