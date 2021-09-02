package com.algdat;

public class NextBigNr {
    public static void main(String[] args){
        int arr[]={300,6,1400,8,9,1000};
        int a[]={7,7,13,9,5,11,13,8};

        System.out.println(findNextBig(a));
        //System.out.println(findMax(a,0,8));

    }

    public static int findNextBig(int[] arr){
        int maxIndex=findMax(arr,0,arr.length);
        int nextBigNr;
        if(maxIndex==0){
            nextBigNr=arr[findMax(arr,maxIndex+1,arr.length)];
        }
        else if(maxIndex==arr.length-1) {
            nextBigNr = arr[findMax(arr, 0, maxIndex)];
        }
        else {
            int nextBigNr1 = arr[findMax(arr, 0, maxIndex)];
            int nextBigNr2 = arr[findMax(arr, maxIndex+1, arr.length)];
            if (nextBigNr1 > nextBigNr2)
                nextBigNr=nextBigNr1;
            else nextBigNr=nextBigNr2;
        }
        return nextBigNr;
    }

    public static int findMax(int[] arr, int fra, int til){
        int maxIndex=fra;
        for(int i=fra+1; i<til; i++){
            if(arr[i]>arr[maxIndex]){
                maxIndex=i;
            }
        }
        return maxIndex;
    }
}
