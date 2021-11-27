package com.algdat.uke36;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int a[]={3,7,2,8,10,6,9,4,5,1};
        System.out.println(Arrays.toString(utvalgsSortering(a)));
    }

    public static int[] utvalgsSortering(int[] a){
        for(int i = 0; i < a.length; i++){
            bytt(a, i, min(a, i, a.length));
        }
        return a;
    }

    public static int min(int[] a, int fra, int til){
        int min = a[fra];
        for(int i = fra + 1; i < til; i++){
            if (min > a[i]){
                min = a[i];
                fra = i;
            }
        }
        return fra;
    }

    public static void bytt(int[] a, int fra, int min){
        int tmp = a[fra];
        a[fra] = a[min];
        a[min] = tmp;
    }
}
