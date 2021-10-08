package com.algdat.uke34;

import java.util.Arrays;

public class MyFirstSort {
    public static void main(String[] args){
        int[] arr={3,7,5,4,6,9};
        myFirstSort(arr);
    }

    public static void myFirstSort(int[] arr){
        for(int i=0; i<arr.length-1; i++){
            int maxIndex=findMax(arr, i, arr.length);
            int temp=arr[i];
            arr[i]=arr[maxIndex];
            arr[maxIndex]=temp;
            for(int j=0; j<arr.length; j++){
                System.out.print(arr[j]+", ");
            }
            System.out.println();
        }
    }

    public static int findMax(int[] arr, int fra, int til){
        int maxIndex=fra;
        int maxVerdi=arr[fra];
        for(int i=fra+1; i<til; i++)
            if(arr[i]>maxVerdi)
            {
                maxVerdi=arr[i];
                maxIndex=i;
            }
        return maxIndex;
    }
}
