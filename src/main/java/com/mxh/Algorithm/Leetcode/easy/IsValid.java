package com.mxh.Algorithm.Leetcode.easy;

import java.util.Stack;

/**
 * 栈 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。 有效字符串需满足 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 
 * @author mxh
 * @version 创建时间：2018年8月16日下午10:17:10 类说明
 */
public class IsValid {
	/**
	 * @Last_update 2018年8月17日上午1:23:15
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
