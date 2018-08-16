package com.mxh.dataStructure.stack;
/**
*@author mxh
*@version 创建时间：2018年8月17日上午12:18:55
*类说明
*/
public class Test {
	public static void main(String[] args) {
		ArrayStack<Integer> array=new ArrayStack<>();
		array.push(123);
		System.out.println(array);
		array.pop();
	}
}
