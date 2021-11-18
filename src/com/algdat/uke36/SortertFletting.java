package com.algdat.uke36;

import java.util.Arrays;

public class SortertFletting {
    public static void main(String[] args) {
        int[] a = {1,3,4,6,9,9,11}, b = {2,3,5,6,7,8,9,10,12,14};
        System.out.println(Arrays.toString(sortertFletting(a,b))); //[1, 2, 3, 3, 4, 5, 6, 6, 7, 8, 9, 9, 9, 10, 11, 12, 14]
    }
    public static int[] sortertFletting(int[] a, int[] b) { //a,b må være sorterte, og kan være med sammen verdier
        int[] c = new int[a.length + b.length];
        int m = a.length;
        int n = b.length;
        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            c[k++] = a[i] <= b[j] ? a[i++] : b[j++];
        }
        while (i < m) {
            c[k++] = a[i++];   // tar med resten av a
        }
        while (j < n) {
            c[k++] = b[j++];   // tar med resten av b
        }
        return c;   // antallet verdier som er lagt inn i c
    }
}
