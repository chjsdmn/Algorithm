package com.algdat.uke41;

/**
 * Stack的顺序就是LIFO，后进先出，所以下面方法进的顺序是
 * main 叫 oppdateA，
 * oppdateA 叫 oppdateB和oppdateC，
 * oppdateB 叫 oppdateC
 * 所以出的顺序，即code执行的顺序是
 * oppdateC -> oppdateB -> oppdateC -> oppdateA -> main
 *
 */

public class Stack {
    public static void main(String[] args) {
        oppdateA();
        System.out.println("main");
    }
    static void oppdateA(){
        oppdateB();
        oppdateC();
        System.out.println("oppdateA");
    }
    static void oppdateB(){
        oppdateC();
        System.out.println("oppdateB");
    }
    static void oppdateC(){
        System.out.println("oppdateC");
    }
}
