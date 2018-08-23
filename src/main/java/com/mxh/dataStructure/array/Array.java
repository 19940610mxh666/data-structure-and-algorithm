package com.mxh.dataStructure.array;

/**
 * ���Ա�����
 * 
 * @author mxh
 * @version ����ʱ�䣺2018��8��15������2:05:18 ��˵��
 */
public class Array<E> {
	private E[] data;
	private int size;
	private int capacity;

	
	public Array(E[] arr){
		data=(E[]) new Object[arr.length];
		for (int i = 0; i < arr.length; i++) {
			data[i] = arr[i];
		}
		size=arr.length;
	}
	
	@SuppressWarnings("unchecked")
	public Array(int capacity) {
		data = (E[]) new Object[capacity];
		this.capacity = capacity;
		size = 0;
	}

	public Array() {
		this(10);
	}

	public void swap(int i,int j){
		if (i<0||i>=size||j<0||j>=size) {
			throw new IllegalArgumentException("index is illegal");
		}
		E e=data[i];
		data[i]=data[j];
		data[j]=e;
	}
	/**
	 * ���������Ԫ�ظ���
	 * 
	 * @Last_update 2018��8��15������10:00:06
	 * @return
	 */
	public int size() {
		return size;
	}

	/**
	 * �������������
	 * 
	 * @Last_update 2018��8��15������10:00:18
	 * @return
	 */
	public int getCapacity() {
		return capacity;
	}

	/**
	 * �����Ƿ�Ϊ��
	 * 
	 * @Last_update 2018��8��15������10:01:26
	 * @return
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * ��ָ��λ�ò���Ԫ��
	 * 
	 * @Last_update 2018��8��15������10:02:12
	 * @param index
	 * @param e
	 */
	public void add(int index, E e) {
		if (index < 0 || index > size)
			throw new IllegalArgumentException("Add failed.Require index must >=0 and index <=size");
		if (size == data.length) {
			resize(data.length << 1);
		}
		for (int i = size - 1; i >= index; i--) {
			data[i + 1] = data[i];
		}
		data[index] = e;
		size++;
	}

	/**
	 * ʵ�ֶ�̬����
	 * 
	 * @Last_update 2018��8��15������11:35:40
	 * @param newCapacity
	 */
	private void resize(int newCapacity) {
		E[] newData = (E[]) new Object[newCapacity];
		for (int i = 0; i < size; i++) {
			newData[i] = data[i];
		}
		capacity = newCapacity;
		data = newData;
	}

	/**
	 * ������ĩβ���Ԫ��
	 * 
	 * @Last_update 2018��8��15������10:13:40
	 * @param e
	 */
	public void addLast(E e) {
		add(size, e);
	}

	/**
	 * �������ײ����Ԫ��
	 * 
	 * @Last_update 2018��8��15������10:25:04
	 * @param e
	 */
	public void addFirst(E e) {
		add(0, e);
	}

	/**
	 * �������
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
	 * ��ѯ������Ԫ��Ϊe��λ�ã�û���򷵻�-1
	 * 
	 * @Last_update 2018��8��15������10:27:06
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

	public E getFirst() {
		return get(0);
	}

	public E getLast() {
		return get(size - 1);
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
	 * �Ƴ�ָ��λ�õ�Ԫ�ز����� ���Ӷ��� ��Ԫ�ظ�����������������1/4ʱ�������ݡ�lazyģʽ �����㷨������
	 * �����1/2ʱ�����ݣ���ô���ǵ�add()����ʱ������Ϊ�ظ���resize()���������ܵ�Ӱ��
	 * 
	 * @Last_update 2018��8��15������10:25:56
	 * @param index
	 * @return
	 */
	public E remove(int index) {
		if (index < 0 || index > size) {
			throw new IllegalArgumentException("index is illegal");
		}
		E ret = data[index];
		for (int i = index+1; i < size; i++) {
			data[i-1] = data[i];
		}
		size--;
		if (size == data.length >>> 2 && data.length >>> 1 != 0) {
			resize(data.length >>> 1);
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
