package com.mxh.dataStructure.stack;

/**
 * @author mxh
 * @version 创建时间：2018年8月17日上午12:15:37 类说明
 */
public interface Stack<E> {
	boolean isEmpty();

	E peek();

	E pop();

	void push(E e);

	int getSize();
}
