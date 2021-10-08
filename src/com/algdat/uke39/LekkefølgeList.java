package com.algdat.uke39;

import java.util.ArrayList;  // 引入 ArrayList 类

/**
 * ArrayList 是一个数组队列，提供了相关的添加、删除、修改、遍历等功能。
 * ArrayList 类是一个可以动态修改的数组，与普通数组的区别就是它是没有固定大小的限制，我们可以添加或删除元素。
 * ArrayList 继承了 AbstractList ，并实现了 List 接口。
 * 以下情况使用 ArrayList :
 * 频繁访问列表中的某一个元素。
 * 只需要在列表末尾进行添加和删除元素操作。
 */

public class LekkefølgeList {
    public static void main(String[] args) {
        ArrayList<Integer> lekkefølgeList = new ArrayList<Integer>();  //只能为引用数据类型, eks. Integer, not int!!
        lekkefølgeList.add(2);
        lekkefølgeList.add(4);
        lekkefølgeList.add(6);
        lekkefølgeList.add(8);
        System.out.println(lekkefølgeList);
        System.out.println(lekkefølgeList.get(0));  //访问第1个元素, 访问 ArrayList 中的元素可以使用 get(index) 方法
        lekkefølgeList.set(0,1);   //修改 ArrayList 中的元素可以使用 set() 方法：第一个参数为索引位置，第二个为要修改的值
        System.out.println(lekkefølgeList);
        lekkefølgeList.remove(3);  //删除 ArrayList 中的元素可以使用 remove(index) 方法
        System.out.println(lekkefølgeList);
        /**
         * 使用 for 配合 size() 方法来迭代列表中的元素
         */
        for(int i = 0; i < lekkefølgeList.size(); i++){
            System.out.println(lekkefølgeList.get(i));
        }
        /**
         * 也可以使用 for-each 来迭代元素
         */
        for(int i : lekkefølgeList){
            System.out.println(i);
        }

    }
}
