package com.mxh.dataStructure.collection;

/**
 * 映射
 * @author mxh
 * @version 创建时间：2018年8月23日上午12:02:39 类说明
 */
public interface Map<K, V> {
	void add(K key, V value);

	V remove(K key);

	boolean contains(K key);

	V get(K key);

	void set(K key, V newValue);

	int getSize();

	boolean isEmpty();
}
