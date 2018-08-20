package com.mxh.dataStructure.bst;

/**
 * @author mxh
 * @version 创建时间：2018年8月21日上午12:16:42 类说明
 */
public class Main {
	public static void main(String[] args) {
		BST<Integer> bst = new BST<>();
		int[] nums = { 5, 3, 6, 8, 4, 2 };
		for (int i : nums) {
			bst.add(i);
		}
		bst.preOrder();
		System.out.println("--------------");
		//System.out.println(bst);
		bst.inOrder();
		System.out.println("--------------");
		bst.postOrder();
	}
}
