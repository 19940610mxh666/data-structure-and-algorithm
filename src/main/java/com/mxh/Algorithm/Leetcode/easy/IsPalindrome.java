package com.mxh.Algorithm.Leetcode.easy;

/**
 * 判断回文
 * 
 * @author mxh
 * @version 创建时间：2018年8月16日上午2:04:23 类说明
 */
public class IsPalindrome {

	public static boolean isPalindrome(int x) {
		if (x<0) {
			return false;
		}
		// 获取x的位数
		int len = (int) Math.log10(x) + 1;
		// 切半判断 二分法
		for (int i = 0; i < (int) len / 2; i++) {
			if ((int) (x / Math.pow(10, len - i - 1)) % 10 != (int) (x % Math.pow(10, i + 1) / (Math.pow(10, i)))) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(IsPalindrome.isPalindrome(10));
	}
}
