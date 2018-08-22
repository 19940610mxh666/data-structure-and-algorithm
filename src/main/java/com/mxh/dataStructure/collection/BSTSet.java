package com.mxh.dataStructure.collection;

import com.mxh.dataStructure.bst.BST;

/**
 * set
 * 
 * @author mxh
 * @version ����ʱ�䣺2018��8��22������11:23:22 ��˵��
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
