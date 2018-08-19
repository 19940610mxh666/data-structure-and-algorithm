package com.mxh.dataStructure.linkedlist;

import java.util.Random;

import com.mxh.dataStructure.stack.ArrayStack;
import com.mxh.dataStructure.stack.Stack;

/**
*@author mxh
*@version 创建时间：2018年8月19日下午9:21:19
*类说明
*/
public class MainTest2 {
	private static double testStack(Stack<Integer> s, int opCount) {
		long startTime = System.nanoTime();
		Random random = new Random();
		for (int i = 0; i < opCount; i++) {
			s.push(random.nextInt(Integer.MAX_VALUE));
		}
		for (int i = 0; i < opCount; i++) {
			s.pop();
		}
		long entTime = System.nanoTime();
		return (entTime - startTime) / 1000000000.0;
	}
	/**
	 * new node 消耗时间
	 * @Last_update 2018年8月19日下午9:27:24
	 * @param args
	 */
	public static void main(String[] args) {
		int opCount=10000;
		ArrayStack<Integer> array=new ArrayStack<>();
		double time1=testStack(array, opCount);
		LinkedListStack<Integer> list=new LinkedListStack<>();
		double time2=testStack(list, opCount);
		System.out.println("ArrayStack:"+time1);
		System.out.println("LinkedListStack:"+time2);
	}
}
