package com.mxh.Algorithm.Leetcode.easy;

/**
 * �жϻ���
 * 
 * @author mxh
 * @version ����ʱ�䣺2018��8��16������2:04:23 ��˵��
 */
public class IsPalindrome {

	public static boolean isPalindrome(int x) {
		if (x<0) {
			return false;
		}
		// ��ȡx��λ��
		int len = (int) Math.log10(x) + 1;
		// �а��ж� ���ַ�
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
