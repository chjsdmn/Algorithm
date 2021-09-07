package com.algdat;

public class FindMinst {
    public static void main(String[] args){
        int arr[]={5,2,9,10,1};
        System.out.println(findMin(arr));
    }

    public static int findMin(int[] a, int fra, int til){
        int minIndex=fra;
        int minVerdi=a[fra];
        for(int i=fra+1; i<til; i++){
            if(a[i]<minVerdi){
                minVerdi=a[i];
                minIndex=i;
            }
        }
        return minIndex;
    }

    public static int findMin(int[] a){
        return findMin(a,0,a.length);
    }

}
