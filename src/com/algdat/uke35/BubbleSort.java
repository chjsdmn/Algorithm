package com.algdat.uke35;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {1, 7, 8, 2, 4, 6, 9, 5};
        System.out.println(Arrays.toString(bubbleSort(arr)));    //[9, 8, 7, 6, 5, 4, 2, 1]
        System.out.println(Arrays.toString(bubbleSort2(arr)));   //[1, 2, 4, 5, 6, 7, 8, 9]
        System.out.println(Arrays.toString(bubbleSort3(arr)));   //[1, 2, 4, 5, 6, 7, 8, 9]

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

    public static int[] bubbleSort3(int[] a){
        int k;   //这个方法比上面的两个方法多设置了一个变量
        for(int i = a.length; i > 0; i--){    //由于每次将最大的换到数列末尾，所以每次i在下面的循环里少一，就是最后一位不用比较了
            for(int j = 0; j < i - 1; j++){   //因为k = j + 1， 所以j要小于i - 1，如果只小于i，那么k就超出了数组范围
                k = j + 1;
                if(a[j] > a[k]){
                    int temp=a[j];
                    a[j]=a[k];
                    a[k]=temp;
                }
            }
        }
        return a;
    }
}
