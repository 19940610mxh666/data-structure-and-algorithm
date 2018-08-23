package com.mxh.dataStructure.heap;

import java.util.Random;

/**
 * @author mxh
 * @version 创建时间：2018年8月23日下午11:50:32 类说明
 */
public class Main {
	private static double testHeap(Integer[] testData, boolean isHeapify) {
		long startTime = System.nanoTime();
		MaxHeap<Integer> maxHeap;
		if (isHeapify) {
			maxHeap = new MaxHeap<>(testData);
		} else {
			maxHeap = new MaxHeap<>();
			for (Integer integer : testData) {
				maxHeap.add(integer);
			}
		}
		int[] arr = new int[testData.length];
		for (int i = 0; i < testData.length; i++) {
			arr[i] = maxHeap.extractMax();
		}
		for (int i = 1; i < testData.length; i++) {
			if (arr[i - 1] < arr[i]) {
				throw new IllegalArgumentException("Error");
			}
		}
		long endTime = System.nanoTime();
		return (endTime - startTime) / 1000000000.0;
	}

	public static void main(String[] args) {
		int n = 2;
		Random random = new Random();
		Integer[] testData = new Integer[n];
		for (int i = 0; i < n; i++) {
			testData[i] = random.nextInt(Integer.MAX_VALUE);
		}
		double time1 = testHeap(testData, false);
		double time2 = testHeap(testData, true);
		System.out.println("time1:"+time1);
		System.out.println("time2:"+time2);
	}
}
