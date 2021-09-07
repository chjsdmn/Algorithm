package com.algdat.uke36;

public class Søking {
    public static void main(String[] args){
        int a[]={3,7,2,5,8};
        int b[]={2,3,4,5,6,7,18};
        int x=18;
        //System.out.println(usortertSøk(a,x));
        //System.out.println(sortertSøk2(b,x));
        System.out.println(binarSøk(b,x));

    }

    public static int usortertSøk(int[] a, int x){
        //int index=-1;
        for(int i=0; i<a.length; i++){
            if(a[i]==x){
                //index=i;
                return i;
            }
        }
        //return index;
        return -1;
    }

    public static int sortertSøk1(int[] a, int x){  //这个方法跟没sortert的数组一样，每个元素都比较，效率不高，请看下方升级版
        for(int i=0;i<a.length;i++){
            if(a[i]==x) return i;
        }
        return -1;
    }

    public static int sortertSøk2(int[] a, int x){
        int step_length=2;  //在一个sortert的数组里，可以不比较每一个元素，而是通过这种跳过一定数量的元素进行比较
        for(int i=0; i<a.length; i+=step_length){  //注意，这里就是每两个元素比较一次
            if(a[i]>=x){
                int begin=i-step_length;
                int end=i+1;
                for(int j=begin; j<end; j++){
                    if(a[j]==x) return j;
                }
                return -1;  //不知道这步有啥用。。。
            }
        }
        return -1;
    }

    public static int binarSøk(int[] a, int x){
        int left=0;
        int right=a.length-1;
        while (left<=right){
            int midt=(left+right)/2;
            if(a[midt]>x){
                right=midt;
            }
            else if(a[midt]<x){
                left=midt+1;
            }
            else
            return midt;
        }
        return -1;
    }
}
