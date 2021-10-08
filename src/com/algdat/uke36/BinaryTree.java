package com.algdat.uke36;

import java.util.Arrays;
import static com.algdat.uke35.BubbleSort.bubbleSort2;

public class BinaryTree {
    public static void main(String[] args){
        int a[]={3,7,2,8,10,6,9,4,5,1};
        int x=10;
        bubbleSort2(a);
        System.out.println(Arrays.toString(a));
        System.out.println(binaryTree(a,x));
        System.out.println(binaryTreeRecursion(a,x,0,9));
    }

    public static int binaryTree(int[] a, int x){
        int left=0;
        int right=a.length-1;
        int midt;
        while (left<=right){  //要有等于号！
            midt=(left+right)/2;
            if(a[midt]>x){
                right=midt-1;
            }
            else if(a[midt]<x){
                left=midt+1;
            }
            else if(a[midt]==x){
                return midt;
            }
            else{
                System.out.println("Noen er feil.");
            }
        }
        return -left;
    }

    public static int binaryTreeRecursion(int[] a, int x, int left, int right){
        int midt=(left+right)/2;
        if(left>right) return -1;
        if(a[midt]>x){
            right=midt-1;
            binaryTreeRecursion(a,x,left,right);
        }
        else if(a[midt]<x){
            left=midt+1;
            binaryTreeRecursion(a,x,left,right);
        }
        else if(a[midt]==x){
            return midt;
        }
        else{
            System.out.println("Noen er feil");
            //return -left;
        }
        return -left;
    }
}

