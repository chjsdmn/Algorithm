package com.algdat.uke35;

import java.util.Arrays;

/**
 * for循环的三部分（initialiseringen； betingelsen； oppdateringen ）
 * 每一部分都可以为空，最极端的可为：
 * for ( ; ; )   这是一个永久循环，在某种情况下可能有用。
 *   {
 *     // kropp
 *   }
 *   可以简写成 fori， intellij就自动生成了一个for loop
 */

public class ForLoop {
    public static void main(String[] args){
        int a[]={3,6,7,9};
        int b[]=new int[a.length];
        int c[]=new int[b.length];
        copierArr(a,b);
        motsattArr(b,c);
        System.out.println(Arrays.toString(b));
        System.out.println(Arrays.toString(c));
        System.out.println(frontCounter(a));
        // forEachLoop(a)  3 6 7 9;
    }

    public static int frontCounter(int[] a){
        int i=0;   // 将counter，即循环的初始点放在循环的外面，然后当循环break的时候，可以知道i的值。
        for( ; i<a.length; i++){
            if(a[i]==7) break;  //在这里循环break
        }
        return i;  //2
    }

    public static int[] copierArr(int[] a, int[] b){
        for(int i=0; i<a.length; i++){
            b[i]=a[i];
        }
        return b;
    }

    public static int[] motsattArr(int[] a, int[] b){
        for(int i=0, j=a.length-1; i<a.length;i++, j--){  //循环可以有两个counter，定义时中间用逗号隔开，类型不用重复写！
            b[j]=a[i];
        }
        return b;
    }
    /**
     * For-alle-løkker/ for-each-loop
     * for (<datatype> <navn> : <objekt>) /(类型 array中每一项 : array)
     *   {
     *     // programsetninger
     *   }
     */
    public static void forEachLoop(int[] a){
        for(int k:a) System.out.println(k);
    }

    /**
     * while-loop
     * 所有可以写成for loop的都可以写成while loop。反之亦然
     * int i = 0;
     *
     *   while (i < a.length)
     *   {
     *     // kropp
     *
     *     i++;
     *   }
     * 或者永恒循环，但是中间要加 break 或者 return
     * while (true)
     *   {
     *     // kropp
     *   }
     */

    /**
     * Do-while loop,即至少会执行一次，即do那个部分
     * do
     *   {
     *     // kropp
     *   }
     *   while (<betingelse>);
     */
}
