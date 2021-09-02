package com.algdat;

public class NextMax {
    public static void main(String[] args){
        int a[]={7,7,13,9,5,11,13,8};
        int nextMax=findNextMax(a);
        System.out.println(nextMax);
    }

    public static int findNextMax(int[] a){
        int maxVerdi=max(a[0],a[1]);
        int nextMaxVerdi=min(a[0],a[1]);
        for(int i=2; i<a.length; i++){
            if(a[i]>nextMaxVerdi){
                if(a[i]>maxVerdi){
                    nextMaxVerdi=maxVerdi;  //这两步的顺序不能错，必须先赋值nextMax，再赋值max，如果颠倒就错了！
                    maxVerdi=a[i];
                }
                else if(a[i]==maxVerdi){
                    maxVerdi=a[i];
                }
                else{
                    nextMaxVerdi=a[i];
                }
            }
        }
        return nextMaxVerdi;
    }

    public static int min(int a, int b){
        int min;
        if(a<=b)
             min=a;
        else min=b;
        return min;
    }

    public static int max(int a, int b){
        int max;
        if(a>=b)
            max=a;
        else max=b;
        return max;
    }
}
