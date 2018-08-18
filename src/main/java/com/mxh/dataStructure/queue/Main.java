package com.mxh.dataStructure.queue;

import java.util.Random;

/**
 * 测试性能
 * 
 * @author mxh
 * @version 创建时间：2018年8月18日上午12:13:18 类说明
 */
public class Main {
	/**
	 * 测试使用q运行opCount个enqueue和dequeue操作所需的时间
	 * 
	 * @Last_update 2018年8月18日上午12:14:18
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
	 * 结果差别很大，而且随着opCount的增大，差距会越来越大。
	 * 这是因为ArrayQueue在dequeue操作时,移除队首元素时(数组头部元素)，内部array会把所有剩余元素前移一位；
	 * 而LoopQueue的dequeue操作时，对于数组(数组的末尾)来说，是直接移除的，剩余元素位置是不变得。
	 * 或者说，在操作LoopQueue时，通过改变front(即访问元素的下标)来取消剩余元素的位移
	 * 而ArrayQueue则是把下标“固定”，每次移除栈顶元素之后，都会“推动”剩余元素
	 * 
	 * @Last_update 2018年8月18日上午12:37:52
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
