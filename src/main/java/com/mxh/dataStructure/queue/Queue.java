package com.mxh.dataStructure.queue;

/**
 * ���� FIFO
 * 
 * @author mxh
 * @version ����ʱ�䣺2018��8��17������9:41:45 ��˵��
 */
public interface Queue<E> {
	int getSize();

	boolean isEmpty();

	void enqueue(E e);

	E dequeue();

	E getFront();
}
