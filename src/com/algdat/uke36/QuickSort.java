package com.algdat.uke36;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args){
        int[] a = {6, 4, 3, 2, 7, 9, 1, 8, 5};
        int[] b = {8, 5, 3, 6, 5, 2, 9, 1};
        int[] c = {2,1};
        quickSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
        quickSort(b, 0, b.length - 1);
        System.out.println(Arrays.toString(b));
        quickSort(c, 0, c.length - 1);
        System.out.println(Arrays.toString(c));
    }
    public static void quickSort(int[] a, int low, int high){
        if(a.length <= 0 || low >= high) return;
        int skillepos = partition(a, low, high);
        quickSort(a, low, skillepos - 1);
        quickSort(a, skillepos+1, high);
    }
    public static int partition(int[] a, int low, int high){
        int midt = (low + high) / 2;
        int i = low;
        int j = high;
        int tmp = a[midt];  //将中间值设为pivot
        a[midt] = a[i];  //将中间值和最左边的值互换
        a[i] = tmp;      //将pivor换到最左边
        int p = a[i];    //所有值都跟最左边的值比较，即跟pivot比较
        /**
         * 挖坑填数 + 分治法
         * 如果是把pivot放在最左边，就要从右边开始找起
         * 如果把pivot放在最右边，那么就要从左边开始找起
         */
        while (i < j){
            while (a[j] > p && i < j){
                j--;
            }
            if(i < j){
                a[i] = a[j];
                i++;
            }
            while(a[i] <= p && i < j){
                i++;
            }
            if(i < j){
                a[j] = a[i];
                j--;
            }
        }
        a[i] = p;  //这步是把一开始存下的p又换回来！！
        return i;
    }
}
