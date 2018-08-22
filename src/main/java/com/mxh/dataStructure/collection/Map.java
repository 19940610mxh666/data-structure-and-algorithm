package com.mxh.dataStructure.collection;

/**
 * ӳ��
 * @author mxh
 * @version ����ʱ�䣺2018��8��23������12:02:39 ��˵��
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
