package com.algdat;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NextBigNrTest {

    @Test
    void findNextBig() {
        int a[]={2,4,9,5,11,8,10};
        int res=NextBigNr.findNextBig(a);
        int truth=10;
        assertEquals(truth,res);
        //assertThrows()
    }
}