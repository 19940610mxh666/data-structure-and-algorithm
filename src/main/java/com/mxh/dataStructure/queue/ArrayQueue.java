package com.mxh.dataStructure.queue;

import com.mxh.dataStructure.array.Array;

/**
 * 队列
 * @author mxh
 * @version 创建时间：2018年8月17日下午9:48:11 类说明
 */
public class ArrayQueue<E> implements Queue<E> {
	private Array<E> array;

	public ArrayQueue() {
		array = new Array<E>();
	}

	public ArrayQueue(int capacity) {
		array = new Array<>(capacity);
	}

	@Override
	public int getSize() {
		return array.size();
	}

	@Override
	public boolean isEmpty() {
		return array.isEmpty();
	}

	@Override
	public void enqueue(E e) {
		array.addLast(e);
	}

	@Override
	public E dequeue() {
		return array.removeFirst();
	}

	@Override
	public E getFront() {
		return array.getFirst();
	}

	public String toString() {
		StringBuilder res = new StringBuilder();
		res.append("Queue:front [");
		for (int i = 0; i < array.size(); i++) {
			res.append(array.get(i));
			if (i != array.size() - 1) {
				res.append(",");
			}
		}
		res.append("]tail");
		return res.toString();
	}

	public static void main(String[] args) {
		System.out.println(1 << 2);
		ArrayQueue<Integer> queue = new ArrayQueue<>();
		for (int i = 0; i < 20; i++) {
			queue.enqueue(i);
			System.out.println(queue);
		}

	}
}
