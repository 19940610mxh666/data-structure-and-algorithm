package com.mxh.dataStructure.bst;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author mxh
 * @version 创建时间：2018年8月21日上午12:16:42 类说明
 */
public class Main {
	public static void main(String[] args) {
		/*BST<Integer> bst = new BST<>();
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
		
		bst.levelOrder();*/
		
		BST<Integer> bst=new BST<>();
		Random random=new Random();
		int n=1000;
		for (int i = 0; i < n; i++) {
			bst.add(random.nextInt(10000));
		}
		ArrayList<Integer> list=new ArrayList<>();
		while(!bst.isEmpty()){
			list.add(bst.removeMin());
		}
		System.out.println(list);
		for (int i = 0; i < list.size()-1; i++) {
			if (list.get(i)>list.get(i+1)) {
				throw new IllegalArgumentException("error");
			}
		}
	}
}
