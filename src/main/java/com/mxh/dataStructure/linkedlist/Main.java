package com.mxh.dataStructure.linkedlist;

/**
 * @author mxh
 * @version 创建时间：2018年8月19日下午1:05:15 类说明
 */
public class Main {
	public static void main(String[] args) {
		LinkedList<Integer> linkedList = new LinkedList<>();
		for (int i = 0; i < 5; i++) {
			linkedList.addFirst(i);
			System.out.println(linkedList);
		}
		linkedList.add(2, 666);
		System.out.println(linkedList);
		linkedList.remove(2);
		System.out.println(linkedList);
		linkedList.removeFirst();
		System.out.println(linkedList);
		linkedList.removerLast();
		System.out.println(linkedList);
	}
}
