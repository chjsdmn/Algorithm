package com.algdat.uke35;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {1, 7, 8, 2, 4, 6, 9, 5};
        int[] newArr=bubbleSort(arr);
        System.out.println(Arrays.toString(newArr));

    }

    public static int[] bubbleSort(int[] a){
        for(int i=0; i<a.length; i++){
            for(int j=a.length-1; j>i; j--){
                if(a[j]>a[j-1]){
                    int temp=a[j];
                    a[j]=a[j-1];
                    a[j-1]=temp;
                }
            }
        }
        return a;
    }

}
