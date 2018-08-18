package com.mxh.dataStructure.queue;

/**
 * 循环队列
 * 
 * @author mxh
 * @version 创建时间：2018年8月17日下午10:44:26 类说明
 */
public class LoopQueue<E> implements Queue<E> {
	private E[] data;
	// 实现循环队列可以不用size变量
	private int size;
	// 队首元素下标
	private int front;
	// 队尾元素下标
	private int tail;

	public LoopQueue(int capacity) {
		data = (E[]) new Object[capacity + 1];
		front = 0;
		tail = 0;
		size = 0;
	}

	public LoopQueue() {
		this(10);
	}

	public int getCapacity() {
		return data.length - 1;
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return front == tail;
	}

	@Override
	public void enqueue(E e) {
		if ((tail + 1) % data.length == front) {
			resize(getCapacity() << 1);
		}
		data[tail] = e;
		tail = (tail + 1) % data.length;
		size++;
	}

	private void resize(int capacity) {
		E[] newData = (E[]) new Object[capacity + 1];
		for (int i = 0; i < size; i++) {
			newData[i] = data[(i + front) % data.length];
		}
		data = newData;
		front = 0;
		tail = size;
	}

	@Override
	public E dequeue() {
		if (isEmpty()) {
			throw new IllegalArgumentException("queue is empty");
		}
		E ret = data[front];
		data[front] = null;
		front = (front + 1) % data.length;
		size--;
		if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {
			resize(getCapacity() / 2);
		}
		return ret;
	}

	@Override
	public E getFront() {
		if (isEmpty()) {
			throw new IllegalArgumentException("queue is empty");
		}
		return data[front];
	}

	public String toString() {
		StringBuilder res = new StringBuilder();
		res.append("LoopQueue:front [");
		for (int i = front; i != tail; i = (i + 1) % data.length) {
			res.append(data[i]);
			if ((i + 1) % data.length != tail) {
				res.append(",");
			}
		}
		res.append("] tail");
		return res.toString();
	}

	public static void main(String[] args) {
		LoopQueue<Integer> queue = new LoopQueue<>();
		for (int i = 0; i < 10; i++) {
			queue.enqueue(i);
			System.out.println(queue);
			if (i % 3 == 2) {
				queue.dequeue();
				System.out.println(queue);
			}
		}

	}
}
