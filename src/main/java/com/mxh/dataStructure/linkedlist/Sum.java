package com.mxh.dataStructure.linkedlist;

/**
 * 递归test
 * 
 * @author mxh
 * @version 创建时间：2018年8月19日下午11:10:42 类说明
 */
public class Sum {
	public static int sum(int[] arr) {
		return sum(arr, 0);
	}

	private static int sum(int[] arr, int l) {
		if (l == arr.length) {
			return 0;
		}
		return arr[l] + sum(arr, l + 1);
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5, 6 };
		System.out.println(sum(nums));
	}
}
