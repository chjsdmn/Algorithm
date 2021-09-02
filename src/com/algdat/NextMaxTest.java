package com.algdat;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NextMaxTest {

    @Test
    void findNextMax() {
        int a[]={6,2,9,4,6,9,7,1,4,8};
        int res=NextMax.findNextMax(a);
        int truth=8;
        assertEquals(truth,res);
    }

    @Test
    void min() {
        int a=10;
        int b=9;
        int res=NextMax.min(a,b);
        int truth=9;
        assertEquals(truth,res);
    }

    @Test
    void max() {
        int a=10;
        int b=9;
        int res=NextMax.max(a,b);
        int truth=10;
        assertEquals(truth,res);
    }
}