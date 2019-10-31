package com.spookyNullPointer.BaseLeveller_v1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryToDecimalTest {

    @Test
    public void testBoundary(){

        String[] eightBitBinary = new String[]{"11111111", "00000000", "1000011", "1001110", "1101111",
                "101101", "1011001", "11111110", "1", "110", "11", "101100", "10111110", "11000111", "111",
                "1111", "11111", "111111", "1111111", "10000000"};
        int[] correctResult = new int[]{255, 0, 67, 78, 111, 45, 89, 254, 1, 6, 3, 44, 190, 199, 7, 15, 31, 63, 127, 128};

        for(int x = 0; x < eightBitBinary.length; x++){
            BinaryToDecimal binaryToDecimal = new BinaryToDecimal(eightBitBinary[x]);
            assertEquals(correctResult[x], binaryToDecimal.getResult());
        }
    }



}