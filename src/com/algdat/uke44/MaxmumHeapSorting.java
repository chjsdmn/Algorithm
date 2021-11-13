package com.algdat.uke44;

import java.util.Arrays;

/**
 * 堆排序(Heapsort)，堆分为大根堆和小根堆，是完全二叉树。（Komplett）
 * 完全二叉树： 除了最后一层之外的其他每一层都被完全填充，并且所有结点都保持向左对齐。
 * 大根堆排序，打印出来是从小到大，升序的顺序排列
 * 小根堆排序，打印出来是从大到小，降序的顺序排列
 * 本代码是大根堆排序，从网上自己找到的资料并加以理解
 */
public class MaxmumHeapSorting {
    public static void main(String[] args) {
        int[] values = {15,8,19,16,5,21,7,23,10,14,3,11,6,17,19,19};
        sortingMaximumHeap(values);
        System.out.println(Arrays.toString(values)); //[3, 5, 6, 7, 8, 10, 11, 14, 15, 16, 17, 19, 19, 19, 21, 23]
    }

    /**
     * 初建堆，之后还要在另一个函数中通过调用来进行调整
     * @param a 整数数组，看作是完全二叉树
     * @param currentNodeRoot  当前父节点位置
     * @param size 节点总数，即数组的长度length
     */
    public static void heapify(int[] a, int currentNodeRoot, int size){
        if(currentNodeRoot < size){  //确认当前结点不得超出数组长度
            int leftChild = currentNodeRoot * 2 + 1;  //完全二叉树有个特性：左边子节点位置 = 当前父节点的两倍 + 1
            int rightChild = currentNodeRoot * 2 + 2;  //完全二叉树有个特性：右边子节点位置 = 当前父节点的两倍 + 2
            int max = currentNodeRoot;  //假设当前结点为值最大的结点
            if(leftChild < size){   //确认当前结点左子结点不得超出数组长度
                if(a[max] < a[leftChild]){  //如果左子比当前结点大，那么左子为最大值
                    max = leftChild;
                }
            }
            if(rightChild < size){   //确认当前结点右子结点不得超出数组长度
                if(a[max] < a[rightChild]){  //如果当前最大值比右子值小，那么右子为最大值
                    max = rightChild;
                }
            }
            if(max != currentNodeRoot){   //如果最大值不是当前结点，那么最大值与当前结点的值交换
                int tmp = a[max];
                a[max] = a[currentNodeRoot];
                a[currentNodeRoot] = tmp;
                heapify(a, max, size);   //recursion，变化了当前的结点为最大值，从拥有最大值的那个结点开始重新建堆
            }
        }
    }

    /**
     * 从数组最后一个元素来进行建堆, 从后往前把最大值推到根部
     * 每执行一次函数，最大的值就会在根部，即数组的第一个值为最大值
     * @param a 整数数组，看作是完全二叉树
     * @param size 节点总数，即数组的长度length
     */
    public static void maxHeapify(int[] a, int size){
        for(int i = size - 1; i >= 0; i--){
            heapify(a, i, size);
        }
    }

    /**
     * 排序，每循环一次，即执行一次maxHeapify函数，找到最大值，即a[0]，
     * 让后让a[0]于最后一个值交换，然后再执行循环，将剩下的值中最大的值和最后一个值交换。。。。
     * 每次size都- i，是因为最大值交换到数组末尾以后，就不再参与比较了，所以每建堆一次，size就减1
     * @param a 整数数组，看作是完全二叉树
     */
    public static void sortingMaximumHeap(int[] a){
        for(int i = 0; i < a.length; i++){
            maxHeapify(a, a.length - i);
            int tmp = a[0];
            a[0] = a[(a.length - 1) - i];
            a[(a.length - 1) - i] = tmp;
        }
    }
}
