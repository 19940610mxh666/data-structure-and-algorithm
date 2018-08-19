package com.mxh.dataStructure.linkedlist;

/**
 * leetcode 203
 * 
 * @author mxh
 * @version 创建时间：2018年8月19日下午10:39:20 类说明
 */
public class RemoveElements {
	public static ListNode remove(ListNode head, int val) {
		while (head != null && head.val == val) {
			head = head.next;
		}
		if (head == null) {
			return null;
		}
		ListNode prev = head;
		while (prev.next != null) {
			if (prev.next.val == val)
				prev.next = prev.next.next;
			else
				prev = prev.next;
		}
		return head;
	}

	public static void main(String[] args) {
		ListNode node = new ListNode(1);
		node.next = new ListNode(2);
		node.next.next = new ListNode(6);
		node.next.next.next = new ListNode(3);
		node.next.next.next.next = new ListNode(4);
		node.next.next.next.next.next = new ListNode(5);
		node.next.next.next.next.next.next = new ListNode(6);
		ListNode s = RemoveElements.remove(node, 6);
		System.out.println(s.val);
		System.out.println(s.next.val);
		System.out.println(s.next.next.val);
		System.out.println(s.next.next.val);
		/*
		 * System.out.println(s.val); System.out.println(s.val);
		 */
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}
/**
 * 1ms
 * 

class Solution {
    public ListNode removeElements(ListNode head, int val) {
         if (head == null) return null;
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }
}*/

