package com.mxh.dataStructure.array;

/**
 * @author mxh
 * @version ����ʱ�䣺2018��8��15������11:12:58 ��˵��
 */
public class Test {
	public static void main(String[] args) {
		Array<Integer> arr = new Array<>(10);
		for (int i = 0; i < 12; i++) {
			arr.addFirst(i);
			System.out.println(arr);
			System.out.println(arr.getCapacity()+":"+arr.size());
		}

	}
}
