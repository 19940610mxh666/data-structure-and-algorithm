package com.mxh.dataStructure.queue;


/**
 * @author mxh
 * @version 创建时间：2018年8月19日下午9:37:10 类说明
 */
public class LinkedListQueue<E> implements Queue<E> {

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

	private Node head, tail;
	private int size;

	public LinkedListQueue() {
		head = null;
		tail = null;
		size = 0;
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public void enqueue(E e) {
		if (tail == null) {
			tail = new Node(e);
			head = tail;
		} else {
			tail.next = new Node(e);
			tail = tail.next;
		}
		size++;
	}

	@Override
	public E dequeue() {
		if (isEmpty()) {
			throw new IllegalArgumentException("empty queue");
		}
		Node retNode = head;
		head = head.next;
		retNode.next = null;
		// 只有一个结点的情况
		if (head == null) {
			tail = null;
		}
		size--;
		return retNode.e;
	}

	@Override
	public E getFront() {
		if (isEmpty()) {
			throw new IllegalArgumentException("empty queue");
		}
		return head.e;
	}

	public String toString() {
		StringBuilder res = new StringBuilder();
		Node cur = head.next;
		res.append("front:");
		while (cur != null) {
			res.append(cur + "->");
			cur = cur.next;
		}
		res.append("Null tail");
		return res.toString();
	}
	

	public static void main(String[] args) {
		LinkedListQueue<Integer> queue = new LinkedListQueue<>();
		for (int i = 0; i < 10; i++) {
			queue.enqueue(i);
			System.out.println(queue);
			if (i % 3 == 2) {
				queue.dequeue();
				System.out.println(queue);
			}
		}

	}
}
