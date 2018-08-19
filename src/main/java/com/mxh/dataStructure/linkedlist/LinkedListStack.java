package com.mxh.dataStructure.linkedlist;

import com.mxh.dataStructure.stack.Stack;

/**
 * 链表实现栈
 * 
 * @author mxh
 * @version 创建时间：2018年8月19日下午4:40:39 类说明
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
