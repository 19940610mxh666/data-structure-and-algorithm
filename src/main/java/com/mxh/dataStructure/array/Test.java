package com.mxh.dataStructure.array;

/**
 * @author mxh
 * @version 创建时间：2018年8月15日下午11:12:58 类说明
 */
public class Test {
	public static void main(String[] args) {
		Array<Integer> arr = new Array<>(10);
		for (int i = 0; i < 12; i++) {
			arr.addFirst(i);
			System.out.println(arr);
			System.out.println(arr.getCapacity()+":"+arr.size());
		}

	}
}
