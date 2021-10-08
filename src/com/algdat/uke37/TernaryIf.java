package com.algdat.uke37;

public class TernaryIf {
    public static void main(String[] args){
        for(int i=0; i<10; i++){
            int a = i;
            int b = TernaryIfTest(a);
            System.out.println(b);
        }
        int a = 10;
        int b = a < 10 ? 1 : 10;
        System.out.println(b);

    }

    public static int TernaryIfTest(int value){
        return value > 5 ? 1 : 0;
    }
}
