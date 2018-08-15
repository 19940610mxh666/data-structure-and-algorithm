package com.mxh.Algorithm.Leetcode.easy;

import java.util.Iterator;

/**
 * 两数之和
 * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
 * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
 * @author mxh
 * @version 创建时间：2018年8月16日上午1:13:07 类说明
 */
public class TwoSum {
	public static void main(String[] args) {
		int nums[] = { 2, 7, 11, 15 };
		int target = 4;
		int res[] = TwoSum.twoSum(nums, target);
		System.out.println(res[0] + "," + res[1]);
	}

	public static int[] twoSum(int[] nums, int target) {
		int res[] = new int[2];
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					res[0] = i;
					res[1] = j;
				}
			}
		}
		return res;
	}
}
