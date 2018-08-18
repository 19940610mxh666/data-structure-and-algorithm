package com.mxh.dataStructure.queue;

import java.util.Random;

/**
 * ��������
 * 
 * @author mxh
 * @version ����ʱ�䣺2018��8��18������12:13:18 ��˵��
 */
public class Main {
	/**
	 * ����ʹ��q����opCount��enqueue��dequeue���������ʱ��
	 * 
	 * @Last_update 2018��8��18������12:14:18
	 * @param q
	 * @param opCount
	 * @return
	 */
	private static double testQueue(Queue<Integer> q, int opCount) {
		long startTime = System.nanoTime();
		Random random = new Random();
		for (int i = 0; i < opCount; i++) {
			q.enqueue(random.nextInt(Integer.MAX_VALUE));
		}
		for (int i = 0; i < opCount; i++) {
			q.dequeue();
		}
		long entTime = System.nanoTime();
		return (entTime - startTime) / 1000000000.0;
	}

	/**
	 * ������ܴ󣬶�������opCount�����󣬲���Խ��Խ��
	 * ������ΪArrayQueue��dequeue����ʱ,�Ƴ�����Ԫ��ʱ(����ͷ��Ԫ��)���ڲ�array�������ʣ��Ԫ��ǰ��һλ��
	 * ��LoopQueue��dequeue����ʱ����������(�����ĩβ)��˵����ֱ���Ƴ��ģ�ʣ��Ԫ��λ���ǲ���á�
	 * ����˵���ڲ���LoopQueueʱ��ͨ���ı�front(������Ԫ�ص��±�)��ȡ��ʣ��Ԫ�ص�λ��
	 * ��ArrayQueue���ǰ��±ꡰ�̶�����ÿ���Ƴ�ջ��Ԫ��֮�󣬶��ᡰ�ƶ���ʣ��Ԫ��
	 * 
	 * @Last_update 2018��8��18������12:37:52
	 * @param args
	 */
	public static void main(String[] args) {
		int opCount = 100000;
		ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
		double time = testQueue(arrayQueue, opCount);
		LoopQueue<Integer> loopQueue = new LoopQueue<>();
		double time1 = testQueue(loopQueue, opCount);
		System.out.println("ArrayQueuetime:" + time);
		System.out.println("LoopQueuetime1:" + time1);
	}
}
