package com.mxh.dataStructure.stack;

/**
 * @author mxh
 * @version ����ʱ�䣺2018��8��17������12:15:37 ��˵��
 */
public interface Stack<E> {
	boolean isEmpty();

	E peek();

	E pop();

	void push(E e);

	int getSize();
}
