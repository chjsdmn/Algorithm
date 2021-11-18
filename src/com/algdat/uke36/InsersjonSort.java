package com.algdat.uke36;

import java.util.Arrays;

public class InsersjonSort {
    public static void main(String[] args) {
        int[] a = {6, 4, 3, 2, 7, 9, 1, 8, 5};
        insersjonSort(a);
        System.out.println(Arrays.toString(a));
    }

    public static int[] insersjonSort(int[] a){
        int i, j, insertTall;
        for (i = 1; i < a.length; i++){
            insertTall = a[i];
            j = i - 1;
            while (j >=0 && insertTall < a[j]){
                a[j + 1] = a[j];
                j--;
            }
            a[j+1] = insertTall;
        }
        return a;
    }
}
