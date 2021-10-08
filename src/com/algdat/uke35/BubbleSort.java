package com.algdat.uke35;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {1, 7, 8, 2, 4, 6, 9, 5};
        System.out.println(Arrays.toString(bubbleSort(arr)));
        System.out.println(Arrays.toString(bubbleSort2(arr)));

    }

    public static int[] bubbleSort(int[] a){
        for(int i=0; i<a.length-1; i++){  //a.length-1, 因为最后一位不用比较了
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

    public static int[] bubbleSort2(int[] a){
        for(int i=0; i<a.length-1; i++){
            for(int j=a.length-1; j>i; j--){
                if(a[j]<a[j-1]){
                    int temp=a[j];
                    a[j]=a[j-1];
                    a[j-1]=temp;
                }
            }
        }
        return a;
    }

}
