package com.algdat.uke39;

import java.util.LinkedList;   //引入 LinkedList 类

/**
 * 链表（Linked list）是一种常见的基础数据结构，是一种线性表，但是并不会按线性的顺序存储数据，而是在每一个节点里存到下一个节点的地址。
 * 链表可分为单向链表和双向链表。
 * 一个单向链表包含两个值: 当前节点的值和一个指向下一个节点的链接。
 * 与 ArrayList 相比，LinkedList 的增加和删除的操作效率更高，而查找和修改的操作效率较低。
 * 以下情况使用 LinkedList :
 * 你需要通过循环迭代来访问列表中的某些元素。
 * 需要频繁的在列表开头、中间、末尾等位置进行添加和删除元素操作。
 */
public class LenkedList {
    public static void main(String[] args) {
        // 使用集合创建链表 LinkedList<E> list = new LinkedList(Collection<? extends E> c); 使用集合创建链表
        // 普通创建方法linkedlist
        LinkedList<String> list = new LinkedList<String>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        System.out.println(list);
        list.addFirst("a");   // 使用 addFirst() 在头部添加元素
        list.addLast("b");    // 使用 addLast() 在尾部添加元素
        System.out.println(list);
        list.removeFirst();   // 使用 removeFirst() 移除头部元素
        list.removeLast();    // 使用 removeLast() 移除尾部元素
        list.remove(0);       // 使用 remove() 移除index元素
        System.out.println(list);
        System.out.println(list.getFirst());   // 使用 getFirst() 获取头部元素
        System.out.println(list.getLast());    // 使用 getLast() 获取尾部元素
        /**
         * 使用 for 配合 size() 方法来迭代列表中的元素
         */
        int size = list.size();   //size() 方法用于计算链表的大小
        for(int i = 0; i < size; i++){
            System.out.println(list.get(i));  //.get(i) 方法用于获取列表中的元素index
        }
        /**
         * 也可以使用 for-each 来迭代元素
         */
        for(String item : list){
            System.out.println(item);
        }
    }
}
