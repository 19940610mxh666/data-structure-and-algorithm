package com.mxh.Algorithm.Leetcode.easy;

import java.util.Stack;

/**
 * ջ ����һ��ֻ���� '('��')'��'{'��'}'��'['��']' ���ַ������ж��ַ����Ƿ���Ч�� ��Ч�ַ��������� �����ű�������ͬ���͵������űպϡ�
 * �����ű�������ȷ��˳��պϡ�
 * 
 * @author mxh
 * @version ����ʱ�䣺2018��8��16������10:17:10 ��˵��
 */
public class IsValid {
	/**
	 * @Last_update 2018��8��17������1:23:15
	 * @param s
	 * @return
	 */
	public static boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		if ("".equals(s)) {
			return true;
		}
		char[] arr = s.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			char c = arr[i];
			if (c == '(' || c == '{' || c == '[') {
				stack.push(c);
			} else {
				if (stack.isEmpty()) {
					return false;
				} else {
					char top = stack.pop();
					if (c == ')' && top != '(') {
						return false;
					}
					if (c == '}' && top != '{') {
						return false;
					}
					if (c == ']' && top != '[') {
						return false;
					}
				}
			}
		}
		return stack.isEmpty();
	}

	public static void main(String[] args) {
		System.out.println(IsValid.isValid("(]"));
	}

}
