package com.mxh.dataStructure.queue;

/**
 * 队列 FIFO
 * 
 * @author mxh
 * @version 创建时间：2018年8月17日下午9:41:45 类说明
 */
public interface Queue<E> {
	int getSize();

	boolean isEmpty();

	void enqueue(E e);

	E dequeue();

	E getFront();
}
