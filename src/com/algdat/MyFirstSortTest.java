package com.algdat;

import static org.junit.jupiter.api.Assertions.*;

class MyFirstSortTest {

    @org.junit.jupiter.api.Test
    void myFirstSort() {
        int arr[]={5,8,3,7,4};
        MyFirstSort.myFirstSort(arr);

        int truth[]={8,7,5,4,3};
        assertArrayEquals(truth, arr);
    }

    @org.junit.jupiter.api.Test
    void findMax() {
        int arr[]={5,8,3,7,4};
        MyFirstSort.findMax(arr,0,5);

        int index=MyFirstSort.findMax(arr,0,5);
        int maxIndex=1;
        int maxVerdi=8;
        assertEquals(maxIndex,index);
        assertEquals(maxVerdi,arr[index]);
    }
}