package com.algdat.uke41;

import java.util.Stack;

public class FactorialTest {
    public static void main(String[] args) {
        System.out.println(stackBasedFactorial(10));
    }
    static int stackBasedFactorial(int n){
        Stack<Integer> factorialStack = new Stack<Integer>(); //创建一个Stack，可以用里面的方法
        int result = 1;
        /* factorialStack.push(n);
        while(!factorialStack.isEmpty()) {
            int current = factorialStack.pop();
            result *= current;
            if(n > 1){
                n = n - 1;
                factorialStack.push(n);
            }
        }*/
        while(n > 1){ //n > 0 er også OK
            factorialStack.push(n);  //向最后一位添加
            if(!factorialStack.isEmpty()) {  //检查是否为空
                int current = factorialStack.pop(); //删除最后一位，并返回最后一位的值
                result *= current;  //5*4*3*2
            }
            n--;
        }
        return result;
    }
}
