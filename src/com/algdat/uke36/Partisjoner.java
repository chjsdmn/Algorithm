package com.algdat.uke36;

import java.util.Arrays;

public class Partisjoner {
    public static void main(String[] args){
        int[] a = {8,3,15,13,1,9,20,3,18,2,6,25,14,8,20,16,5,21,11,14};
        System.out.println(parter(a, 0, a.length - 1, 11));
        System.out.println(a[9]);
    }

    private static int parter(int[] a, int v, int h, int skilleverdi){
        while (true){
            while (v <= h && a[v] < skilleverdi) v++;
            while (v <= h && a[h] >= skilleverdi) h--;
            if(v < h){
                bytte(a, v, h);
                System.out.println(Arrays.toString(a));
            }
            else return v;
        }
    }

    static int[] bytte(int[] a, int v, int h) {
        int tmp = a[v];
        a[v] = a[h];
        a[h] = tmp;
        return a;
    }
}
