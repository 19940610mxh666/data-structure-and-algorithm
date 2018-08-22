package com.mxh.dataStructure.collection;
/**
*@author mxh
*@version 创建时间：2018年8月22日下午11:00:17
*类说明
*/
public interface Set<E> {
	void add(E e);
	void remove(E e);
	boolean contains(E e);
	boolean isEmpty();
	int getSize();
}
