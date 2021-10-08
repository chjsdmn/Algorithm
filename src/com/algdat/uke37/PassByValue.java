package com.algdat.uke37;

import java.util.Arrays;

public class PassByValue {
    public static void main(String[] args){
        int a = 1;
        int[] b={1};
        int a2 = 1;
        int[] b2={1};
        passByValue(a);  //1
        passByReferance(b); //[3]
        System.out.println(a);
        System.out.println(Arrays.toString(b));
        System.out.println(passByValue2(a2)); //3
        System.out.println(passByReferance2(b2)); //3

    }

    //Pass by value: ting kopieres inn i funksjonen.
    public static void passByValue(int value){
        value+=2;
    }
    public static int passByValue2(int value){
        return value+=2;
    }

    //Pass by reference: vi sender en peker til det faktiske objektet.
    public static void passByReferance(int[] value){
        value[0] += 2;
    }
    public static int passByReferance2(int[] value){
        return value[0] += 2;
    }
}
