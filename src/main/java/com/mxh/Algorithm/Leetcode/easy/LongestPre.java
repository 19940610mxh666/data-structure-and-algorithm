package com.mxh.Algorithm.Leetcode.easy;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀 如果不存在公共前缀，返回空字符串 ""。
 * 
 * @author mxh
 * @version 创建时间：2018年8月16日下午5:58:23 类说明
 */
public class LongestPre {
	public static String longestCommonPrefix(String[] strs) {
		for (int i = 0; i < strs.length; i++) {
			if (strs[i].length()==0) {
				return "";
			}
		}
		if (strs.length==1) {
			return strs[0];
		}
		String res = "";
		for (int i = 0; i < strs.length - 1; i++) {
			res = "";
			String temp = strs[i];
			for (int j = 0; j < (((temp.length() - strs[i + 1].length()) <= 0) ? temp.length()
					: strs[i + 1].length()); j++) {
				char c1 = strs[i].charAt(j);
				char c2 = strs[i + 1].charAt(j);
				if (j > 0 && c1 != c2) {
					strs[i + 1] = res;
					continue;
				}
				if (c1 != c2 && j == 0) {
					return "";
				}
				res = res + c1;
				if (j==(((temp.length() - strs[i + 1].length()) <= 0) ? temp.length()-1
					: strs[i + 1].length()-1)) {
					strs[i + 1] = res;
					continue;
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		String[] strs = {"ap","apb","apb"};
		System.out.println(LongestPre.longestCommonPrefix(strs));
	}
}

/*最快的方法
 * class Solution {
    public String longestCommonPrefix(String[] strs) {
    if (strs == null || strs.length == 0)
        return "";
    int minLen = Integer.MAX_VALUE;
    for (String str : strs)
        minLen = Math.min(minLen, str.length());
    int low = 1;
    int high = minLen;
    while (low <= high) {
        int middle = (low + high) / 2;
        if (isCommonPrefix(strs, middle))
            low = middle + 1;
        else
            high = middle - 1;
    }
    return strs[0].substring(0, (low + high) / 2);
}

private boolean isCommonPrefix(String[] strs, int len){
    String str1 = strs[0].substring(0,len);
    for (int i = 1; i < strs.length; i++)
        if (!strs[i].startsWith(str1))
            return false;
    return true;
}
}*/
