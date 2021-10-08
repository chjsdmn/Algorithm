package com.algdat.uke38;

import java.util.Arrays;

public class RekursivePermutasjon {
    public static void main(String[] args){
        int[] a = {1, 2, 3};
        lagePermutasjon(a, 0);
    }

    /**
     *
     * @param a array
     * @param k 跟第几位开始换，即k后面的依次跟k换。k是0，即值是1，所以213，321.
     */
    public static void lagePermutasjon(int[] a, int k){
        if(k == a.length - 1){   //当换到最后一位时，就打印出来
            System.out.println(Arrays.toString(a));
        }
        /**过程是这样的
         * 第一层递归  第二层递归  第三层递归           从第三层返回到第二层  从第二层返回到第一层
         * i=k=0   -> i=k=1 -> i=k=2 -> print [1,2,3] -> i=2,k=1 -> i=k=2 -> print [1,3,2]
         * i=1,k=0 -> i=k=1 -> i=k=2 -> print [2,1,3] -> i=2,k=1 -> i=k=2 -> print [2,3,1]
         * i=2,k=0 -> i=k=1 -> i=k=2 -> print [3,2,1] -> i=2,k=1 -> i=k=2 -> print [3,1,2]
         */
        for(int i = k; i < a.length ; i++){  //i=k并不意味这i一直跟k相等，只是在循环的起点（第一次）时相等，之后k不变，i增大1
            swap(a, i, k);
            lagePermutasjon(a, k+1);
            swap(a, k, i);
        }
    }
    static void swap(int[] a, int x, int y){
        int tmp = a[x];
        a[x] = a[y];
        a[y] = tmp;
    }
}
