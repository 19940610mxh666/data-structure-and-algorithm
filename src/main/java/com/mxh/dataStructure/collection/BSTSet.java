package com.mxh.dataStructure.collection;

import com.mxh.dataStructure.bst.BST;

/**
 * set
 * 
 * @author mxh
 * @version 创建时间：2018年8月22日下午11:23:22 类说明
 */
public class BSTSet<E extends Comparable<E>> implements Set<E> {

	private BST<E> bst;

	public BSTSet() {
		bst = new BST<>();
	}

	@Override
	public void add(E e) {
		bst.add(e);
	}

	@Override
	public void remove(E e) {
		bst.remove(e);
	}

	@Override
	public boolean contains(E e) {
		return bst.contains(e);
	}

	@Override
	public boolean isEmpty() {
		return bst.isEmpty();
	}

	@Override
	public int getSize() {
		return bst.size();
	}

}
