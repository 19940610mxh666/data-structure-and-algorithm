package com.mxh.dataStructure.collection;
/**
*@author mxh
*@version ����ʱ�䣺2018��8��22������11:00:17
*��˵��
*/
public interface Set<E> {
	void add(E e);
	void remove(E e);
	boolean contains(E e);
	boolean isEmpty();
	int getSize();
}
