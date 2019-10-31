package com.spookyNullPointer.BaseLeveller_v1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryToDecimalTest {

    @Test
    public void testBoundary(){

        String[] eightBitBinary = new String[]{"11111111", "00000000" };
        int[] correctResult = new int[]{255, 0};

        for(int x = 0; x < eightBitBinary.length; x++){
            BinaryToDecimal binaryToDecimal = new BinaryToDecimal(eightBitBinary[x]);
            assertEquals(correctResult[x], binaryToDecimal.getResult());
        }
    }



}