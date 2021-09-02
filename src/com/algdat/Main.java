package com.algdat;

public class Main {

    public static void main(String[] args) {
	    int arr[]={1,2,4,3,6,7,9,5,8,10};
	    int arr2[]={1,2,3,4,5};
		int counter=inversjoner(arr);
		System.out.println(counter);
		System.out.println(erSortert(arr2));
    }

    public static int inversjoner(int[] arr){
    	int counter=0;
    	for(int i=0; i<arr.length-1; i++){
    		for(int j=i+1; j<arr.length; j++){
    			if(arr[i]>arr[j])
    				counter++;
			}
		}
    	return counter;
	}

	public static boolean erSortert(int[] arr){
    	for(int i=0; i<arr.length-1; i++){
    		if(arr[i]>arr[i+1])
    			return false;
		}
		return true;
	}
}
