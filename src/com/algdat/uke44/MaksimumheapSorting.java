package com.algdat.uke44;

import java.util.Arrays;

/**
 * 教科书上的内容，不是很理解。。。。
 */
public class MaksimumheapSorting {
    public static void main(String[] args) {
        int[] a = {15,8,19,16,5,21,7,23,10,14,3,11,6,17,19,19};
        lageMaksimumHeap(a);
        System.out.println(Arrays.toString(a));   // [23,21,19,16,14,15,17,8,10,5,3,11,6,7]
        maksimumHeapSorting(a);
        System.out.println(Arrays.toString(a));
    }

    /**
     * 返回升序排列的数组
     * 特征有：
     * n为数组长度，即最后一个元素的index：
     * 1，当 2*k + 1 < n 时，k有两个子结点
     * 2. 当 2*k + 1 = n 时，k有一个子结点
     * 当最大值（数组第一个元素）移除后，长度为n-1：
     * 1.当 2*k + 1 < （n - 1） 时，k有两个子结点
     * 2. 2*（k + 1） < n 时，k有两个子结点
     * 3. k < (n - 1)/2 时，k有两个子结点
     * @param a
     */
    public static void maksimumHeapSorting(int[] a){
        for(int n = a.length - 1; n > 0; n--){   //n为最后一个元素
            int verdi = a[n];  //将最后一个值存起来
            a[n] = a[0]; //将第一个值赋值给最后一个，即数组中最大的值
            int k = 0;
            int m = (n -1) / 2;   //stoppverdi，即只有一个子结点的结点
            while ( k < m ){   //当k有两个子节点时
                int barn = 2*k + 1;
                if(a[barn + 1] > a[barn]){
                    barn ++;
                }
                a[k] = a[barn];  //值变成较大的子节点，即较大值往上推
                k = barn;  //k向下走，较大值往上推
            }
            //不懂
            if (2*(k + 1) == n)                   // k har kun et venstre barn
            {
                k = 2*k + 1;                        // k går til venstre barn
                a[(k - 1)/2] = a[k];                // forskyver oppover
            }

            int parent = (k - 1) / 2;   //设置k的父节点
            while (k > 0 && verdi > a[parent]){  //如果之前存的数组的最后一个值比现在k的父节点的值大
                a[k] = a[parent];  //将小的值拉下来
                k = parent;    //将k往上推
                parent = (k - 1) / 2;   //将父节点往上推，继续跟之前存的值比较
            }
            a[k] = verdi;  //找到适当的位置后，将数组最后一个元素的值放到这里
        }
    }
    /**
     * 建堆，为sorting做准备
     * heaptree的’index‘的一些特征：
     * 如果当前结点是k，那么：
     * 1.leftChild = 2k + 1
     * 2.rightChild = 2k + 2
     * 3.parent = （k - 1）| 2
     * @param a
     */
    public static void lageMaksimumHeap(int[] a){
        for(int i = 1; i < a.length; i++){   //i从1开始，因为要保证k的父节点（k-1）不超出范围
            int k = i;  //将i赋值给k，因为k之后会有变化
            int verdi = a[i];   //将a[i]存入变量，因为之后要一直跟这一变量比较
            int parent = (k - 1) / 2;
            while (k > 0 && verdi > a[parent]){    //当存入的变量（最初的a[k]）比他的父节点大的时候
                a[k] = a[parent];  //与父节点交换
                k = parent;   //将k向上提一级
                parent = (k - 1) / 2;    //将k的父也向上提一级，然后如果最初的a[k]还是大于这个新父，那么就继续交换，直到将k推到root，为0，循环结束
            }
            a[k] = verdi;  //循环结束时，就是找到最终verid（最初的a[k]）该有的位置，赋值
        }
    }
}
