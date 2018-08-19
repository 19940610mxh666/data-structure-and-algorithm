package com.mxh.dataStructure.linkedlist;

import com.mxh.dataStructure.stack.Stack;

/**
 * ����ʵ��ջ
 * 
 * @author mxh
 * @version ����ʱ�䣺2018��8��19������4:40:39 ��˵��
 */
public class LinkedListStack<E> implements Stack<E> {

	private LinkedList<E> list;

	public LinkedListStack() {
		list = new LinkedList<>();
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public E peek() {
		return list.getFirst();
	}

	@Override
	public E pop() {
		return list.removeFirst();
	}

	@Override
	public void push(E e) {
		list.addFirst(e);
	}

	@Override
	public int getSize() {
		return list.getSize();
	}

	public String toString() {
		StringBuilder res = new StringBuilder();
		res.append("Stack:top");
		res.append(list);
		return res.toString();
	}

	public static void main(String[] args) {
		LinkedListStack<Integer> stack = new LinkedListStack<>();
		for (int i = 0; i < 5; i++) {
			stack.push(i);
		}
		System.out.println(stack);
	}
}
