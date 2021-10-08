package com.algdat.uke38;

public class BinarySort {
    public static void main(String[] args){
        int[] a={1, 2, 4, 8, 17, 19, 22};
        System.out.println(binarySort(a, 0, a.length - 1, 22));
    }
    //recursjon的方法
    public static int binarySort(int[] a, int left, int right, int x){
        int midt = (left + right) / 2;
        if(left <= right) {   //这步是为了防止如果x没有出现在a中而产生无线循环。。。
            if(x == a[midt]){  //recursjon的终止点
                return midt;
            }
            else if (a[midt] < x) {
                return binarySort(a, midt + 1, right, x);  //每次call recursion，参数要变化
            }
            else {
                return binarySort(a, left, midt - 1, x);   //每次call recursion，参数要变化
            }
        }
        return -left;
    }
    //普通方法
    /*public static int binarySort(int[] a, int left, int right, int x){
        int midt = (left + right) / 2;
        while (left < right) {
            if (x < a[midt]) {
                right = midt - 1;
                midt = (left + right) / 2;
            }
            else if (x > a[midt]){
                left = midt + 1;
                midt = (left + right) / 2;
            }
            else return midt;
        }
        if(x == midt) {
            return midt;
        }
        else return -1;
    }*/

}
