package com.mxh.dataStructure.array;

/**
 * 线性表数组
 * 
 * @author mxh
 * @version 创建时间：2018年8月15日下午2:05:18 类说明
 */
public class Array<E> {
	private E[] data;
	private int size;
	private int capacity;

	@SuppressWarnings("unchecked")
	public Array(int capacity) {
		data = (E[]) new Object[capacity];
		size = 0;
	}

	public Array() {
		this(10);
	}

	/**
	 * 返回数组的元素个数
	 * 
	 * @Last_update 2018年8月15日下午10:00:06
	 * @return
	 */
	public int size() {
		return size;
	}

	/**
	 * 返回数组的容量
	 * 
	 * @Last_update 2018年8月15日下午10:00:18
	 * @return
	 */
	public int getCapacity() {
		return capacity;
	}

	/**
	 * 数组是否为空
	 * 
	 * @Last_update 2018年8月15日下午10:01:26
	 * @return
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * 在指定位置插入元素
	 * 
	 * @Last_update 2018年8月15日下午10:02:12
	 * @param index
	 * @param e
	 */
	public void add(int index, E e) {
		if (index < 0 || index > size)
			throw new IllegalArgumentException("Add failed.Require index must >=0 and index <=size");
		if (size == data.length)
			resize(data.length << 2);
		for (int i = size - 1; i >= index; i--) {
			data[i + 1] = data[i];
		}
		data[index] = e;
		size++;
	}

	/**
	 * 实现动态数组
	 * 
	 * @Last_update 2018年8月15日下午11:35:40
	 * @param newCapacity
	 */
	private void resize(int newCapacity) {
		E[] newData = (E[]) new Object[newCapacity];
		for (int i = 0; i < size; i++) {
			newData[i] = data[i];
		}
		data = newData;
	}

	/**
	 * 在数组末尾添加元素
	 * 
	 * @Last_update 2018年8月15日下午10:13:40
	 * @param e
	 */
	public void addLast(E e) {
		if (size == data.length)
			throw new IllegalArgumentException("Add failed.Array is full");
		add(size, e);
	}

	/**
	 * 在数组首部添加元素
	 * 
	 * @Last_update 2018年8月15日下午10:25:04
	 * @param e
	 */
	public void addFirst(E e) {
		if (size == data.length)
			throw new IllegalArgumentException("Add failed.Array is full");
		add(0, e);
	}

	/**
	 * 输出数组
	 */
	@Override
	public String toString() {
		StringBuilder res = new StringBuilder();
		res.append("[");
		for (int i = 0; i < size; i++) {
			res.append(data[i]);
			if (i != size - 1) {
				res.append(",");
			}
		}
		res.append("]");
		return res.toString();
	}

	/**
	 * 查询数组中元素为e的位置，没有则返回-1
	 * 
	 * @Last_update 2018年8月15日下午10:27:06
	 * @param e
	 * @return
	 */
	public int find(E e) {
		for (int i = 0; i < size; i++) {
			if (data[i].equals(e)) {
				return i;
			}
		}
		return -1;
	}

	public E get(int index) {
		if (index < 0 || index > size) {
			throw new IllegalArgumentException("index is illegal");
		}
		return data[index];
	}

	public void set(int index, E e) {
		if (index < 0 || index > size) {
			throw new IllegalArgumentException("index is illegal");
		}
		data[index] = e;
	}

	public boolean Contains(E e) {
		for (int i = 0; i < size; i++) {
			if (data[i].equals(e)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 移除指定位置的元素并返回
	 * 
	 * @Last_update 2018年8月15日下午10:25:56
	 * @param index
	 * @return
	 */
	public E remove(int index) {
		if (index < 0 || index > size) {
			throw new IllegalArgumentException("index is illegal");
		}
		E ret = data[index];
		for (int i = index; i < size; i++) {
			data[i] = data[i + 1];
		}
		size--;
		if (size == data.length >>> 2) {
			resize(data.length >>> 2);
		}
		return ret;
	}

	public E removeLast() {
		return remove(size - 1);
	}

	public E removeFirst() {
		return remove(0);
	}

	public void removeElement(E e) {
		int index = find(e);
		if (index != -1) {
			remove(index);
		}
	}
}
