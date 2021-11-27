package com.algdat.uke36;

import java.util.Arrays;

public class SortertFletting {
    public static void main(String[] args) {
       // int[] a1 = {1,3,4,6,9,9,11}, b1 = {2,3,5,6,7,8,9,10,12,14};
        //System.out.println(Arrays.toString(sortertFletting(a1,b1))); //[1, 2, 3, 3, 4, 5, 6, 6, 7, 8, 9, 9, 9, 10, 11, 12, 14]
        int[] a = {1,3,5,7,9};
        int[] b = {2,3,5,6,8};
        int[] c = new int[a.length + b.length];
        int k = ukjent(a,b,c);
        for (int i = 0; i < k; i++) System.out.print(c[i] + " ");  //1,2,6,7,8,9
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

    public static int ukjent(int[] a, int[] b, int[] c)
    {
        int i = 0, j = 0, k = 0;
        while ( i < a.length && j < b.length)
        {
            if (a[i] < b[j]) c[k++] = a[i++];
            else if (a[i] == b[j]) { i++; j++; }
            else  c[k++] = b[j++];
        }
        while (i < a.length) c[k++] = a[i++];
        while (j < b.length) c[k++] = b[j++];
        return k;
    }

}
