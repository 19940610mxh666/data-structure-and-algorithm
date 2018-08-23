package com.mxh.dataStructure.heap;

import com.mxh.dataStructure.array.Array;

/**
 * @author mxh
 * @version 创建时间：2018年8月23日下午10:36:54 类说明
 */
public class MaxHeap<E extends Comparable<E>> {
	private Array<E> data;

	public MaxHeap(int capacity) {
		data = new Array<>(capacity);
	}

	public MaxHeap() {
		data = new Array<>();
	}

	public int size() {
		return data.size();
	}

	public boolean isEmpty() {
		return data.isEmpty();
	}

	// 返回一个索引对应元素的父节点的索引
	private int parent(int index) {
		if (index == 0) {
			throw new IllegalArgumentException("index-0 doesn't have parent");
		}
		return (index - 1) / 2;
	}

	// 返回一个索引对应元素的左子节点的索引
	private int leftChild(int index) {
		return index * 2 + 1;
	}

	// 返回一个索引对应元素的右子节点的索引
	private int rightChild(int index) {
		return index * 2 + 2;
	}

	// sift up
	public void add(E e) {
		data.addLast(e);
		siftUp(data.size() - 1);
	}

	private void siftUp(int k) {
		while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0) {
			data.swap(k, parent(k));
			k = parent(k);
		}
	}

	// 看堆中最大元素
	public E findMax() {
		if (data.size() == 0) {
			throw new IllegalArgumentException("can't fandMAX");
		}
		return data.get(0);
	}

	// 取出堆中最大元素
	public E extractMax() {
		E ret = findMax();
		data.swap(0, data.size() - 1);
		data.removeLast();
		siftDown(0);
		return ret;
	}

	private void siftDown(int k) {
		while (leftChild(k) < data.size()) {
			int j = leftChild(k);
			if (j + 1 < data.size() && data.get(j + 1).compareTo(data.get(j)) > 0) {
				j = rightChild(k);
			}
			if (data.get(k).compareTo(data.get(j)) >= 0) {
				break;
			}
			data.swap(k, j);
			k = j;
		}
	}

	// 取出堆中的最大元素，并且提换成元素e
	public E replace(E e) {
		E ret = findMax();
		data.set(0, e);
		siftDown(0);
		return ret;
	}

	public MaxHeap(E[] arr) {
		data = new Array<>(arr);
		//最后一个叶子节点的父节点的索引
		for (int i = parent(arr.length - 1); i >= 0; i--) {
			siftDown(i);
		}
	}
}
