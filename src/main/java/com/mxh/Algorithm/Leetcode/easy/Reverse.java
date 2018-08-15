package com.mxh.Algorithm.Leetcode.easy;

/**
 * ����һ�� 32 λ�з����������������е����ֽ��з�ת��
 * 
 * @author mxh
 * @version ����ʱ�䣺2018��8��16������1:22:51 ��˵��
 */
public class Reverse {
	public static void main(String[] args) {
		System.out.println(Reverse.reverse(1534236469));
	}

	public static int reverse(int x) {
		int i = 0;
		int res = 0;
		while (x % 10 != 0 || x / 10 != 0) {
			res = x % 10;
			x = x / 10;
			// i*10 < Integer.MIN_VALUE || i*10 > Integer.MAX_VALUE ����
			if (i < Integer.MIN_VALUE / 10 || i > Integer.MAX_VALUE / 10) {
				return 0;
			}
			i = i * 10 + res;
		}

		return i;
	}
}
