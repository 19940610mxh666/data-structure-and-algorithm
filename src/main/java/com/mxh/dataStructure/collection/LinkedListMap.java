package com.mxh.dataStructure.collection;

/**
 * @author mxh
 * @version 创建时间：2018年8月23日上午12:05:22 类说明
 */
public class LinkedListMap<K, V> implements Map<K, V> {

	private class Node {
		public K key;
		public V value;
		public Node next;

		public Node(K key, V value, Node next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}

		public Node() {
			this(null, null, null);
		}

		public String toString() {
			return key.toString() + ":" + value.toString();
		}
	}

	private Node dummyHead;
	private int size;

	public LinkedListMap() {
		this.dummyHead = new Node();
		size = 0;
	}

	@Override
	public void add(K key, V value) {
		Node node = getNode(key);
		if (node == null) {
			dummyHead.next = new Node(key, value, dummyHead.next);
			size++;
		} else {
			node.value = value;
		}

	}

	@Override
	public V remove(K key) {
		Node prv = dummyHead;
		while (prv.next != null) {
			if (prv.next.key.equals(key)) {
				break;
			}
			prv = prv.next;
		}
		if (prv.next != null) {
			Node delNode = prv.next;
			prv.next = delNode.next;
			delNode.next = null;
			size--;
			return delNode.value;
		}
		return null;
	}

	@Override
	public boolean contains(K key) {
		return getNode(key) != null;
	}

	private Node getNode(K key) {
		Node cur = dummyHead.next;
		while (cur != null) {
			if (cur.key.equals(key)) {
				return cur;
			}
			cur = cur.next;
		}
		return null;
	}

	@Override
	public V get(K key) {
		Node node = getNode(key);
		return node == null ? null : node.value;
	}

	@Override
	public void set(K key, V newValue) {
		Node node = getNode(key);
		if (node == null) {
			throw new IllegalArgumentException(key + " doesn't exist");
		} else {
			node.value = newValue;
		}
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

}
