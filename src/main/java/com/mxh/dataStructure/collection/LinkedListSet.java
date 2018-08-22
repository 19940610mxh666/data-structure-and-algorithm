package com.mxh.dataStructure.collection;

import com.mxh.dataStructure.linkedlist.LinkedList;

/**
 * @author mxh
 * @version 创建时间：2018年8月22日下午11:34:25 类说明
 */
public class LinkedListSet<E> implements Set<E> {

	private LinkedList<E> list;

	public LinkedListSet() {
		list = new LinkedList<>();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void add(E e) {
		if (!list.contains(e)) {
			list.addFirst(e);
		}
	}

	@Override
	public void remove(E e) {
		list.removeElement(e);
	}

	@Override
	public boolean contains(E e) {
		return list.contains(e);
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public int getSize() {
		return list.getSize();
	}

}
