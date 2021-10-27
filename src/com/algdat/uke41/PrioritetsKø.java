package com.algdat.uke41;

import java.util.*;

/**
 * priorityQueue 是queue，但是不同意queue，他可以按照优先级出，数字就是按大小，String就是按字母顺序(A最大)
 * Queue是一个接口，所以不能new Queue<>()，但是可以通过LinkedList类和PriorityQueue类来实现Queue接口的方法
 */
public class PrioritetsKø {
    public static void main(String[] args) {
        Queue<Integer> prioritetsKø = new PriorityQueue<>();
        prioritetsKø.add(5);
        prioritetsKø.add(-5);
        prioritetsKø.add(50);
        prioritetsKø.offer(25);
        prioritetsKø.add(-15);
        //System.out.println(prioritetsKø);  不要这样print，出来的结果不准确，要用下面的方式
        while (!prioritetsKø.isEmpty()){
            System.out.print(prioritetsKø.poll() + " ");
        }
        System.out.println();

        Queue<Integer> prioritetsKø2 = new PriorityQueue<>(Collections.reverseOrder());
        prioritetsKø2.add(5);
        prioritetsKø2.add(-5);
        prioritetsKø2.add(50);
        prioritetsKø2.add(25);
        prioritetsKø2.add(-15);
        while (!prioritetsKø2.isEmpty()){
            System.out.print(prioritetsKø2.poll() + " ");
        }
        System.out.println();

        Queue<String> prioritetsKø3 = new PriorityQueue<>();
        prioritetsKø3.add("hello");
        prioritetsKø3.add("gooday");
        prioritetsKø3.add("bye");
        prioritetsKø3.add("hadet");
        prioritetsKø3.add("nice");
        while (!prioritetsKø3.isEmpty()){
            System.out.print(prioritetsKø3.poll() + " ");
        }
        System.out.println();

        Queue<String> prioritetsKø4 = new PriorityQueue<>(Collections.reverseOrder());
        prioritetsKø4.add("hello");
        prioritetsKø4.add("gooday");
        prioritetsKø4.add("bye");
        prioritetsKø4.add("hadet");
        prioritetsKø4.add("nice");
        while (!prioritetsKø4.isEmpty()){
            System.out.print(prioritetsKø4.poll() + " ");
        }
    }
}
