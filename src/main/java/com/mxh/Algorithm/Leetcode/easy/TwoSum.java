package com.mxh.Algorithm.Leetcode.easy;

import java.util.Iterator;

/**
 * ����֮��
 * ����һ�����������һ��Ŀ��ֵ���ҳ������к�ΪĿ��ֵ����������
 * ����Լ���ÿ������ֻ��Ӧһ�ִ𰸣���ͬ����Ԫ�ز��ܱ��ظ����á�
 * @author mxh
 * @version ����ʱ�䣺2018��8��16������1:13:07 ��˵��
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
