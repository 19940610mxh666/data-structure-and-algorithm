package com.mxh.dataStructure.stack;

import com.mxh.dataStructure.array.Array;

/**
 * ջ
 * 
 * @author mxh
 * @version ����ʱ�䣺2018��8��17������12:16:40 ��˵��
 */
public class ArrayStack<E> implements Stack<E> {

	private Array<E> array;

	public ArrayStack() {
		array = new Array<>();
	}

	public ArrayStack(int capacity) {
		array = new Array<>(capacity);
	}

	@Override
	public boolean isEmpty() {
		return array.isEmpty();
	}

	@Override
	public E peek() {
		return array.getLast();
	}

	@Override
	public E pop() {
		return array.removeLast();
	}

	@Override
	public void push(E e) {
		array.addLast(e);
	}

	@Override
	public int getSize() {
		return array.size();
	}

	public String toString() {
		StringBuilder res = new StringBuilder();
		res.append("stack:[");
		for (int i = 0; i < array.size(); i++) {
			res.append(array.get(i));
			if (i != array.size() - 1) {
				res.append(",");
			}
		}
		return res.append("] top").toString();
	}
}
