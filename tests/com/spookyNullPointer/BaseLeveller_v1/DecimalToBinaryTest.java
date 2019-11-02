package com.spookyNullPointer.BaseLeveller_v1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DecimalToBinaryTest {

    @Test
    public void testAllEightBit(){
        String[] allEightBitBinaryResult = new String[] {"11111111", "11111110", "11111101", "11111100", "11111011",
                "11111010", "11111001", "11111000", "11110111", "11110110", "11110101", "11110100", "11110011",
                "11110010", "11110001", "11110000", "11101111", "11101110", "11101101", "11001000", "11000111",
                "11000110", "11000101", "11000100", "10111001", "10101110", "10100011", "10011000", "10001101",
                "10000010", "10000001", "01110110", "01101011", "01100100", "01100011", "01010001", "01001111", "01000100",
                "00111001", "00101110", "00100011", "00010111", "00001010", "00001001", "00001000", "00000111", "00000110",
                "00000101", "00000100", "00000011", "00000010", "00000001"};
        int[] allEightBitBinaryTest = new int[] {255, 254, 253, 252, 251, 250, 249, 248, 247, 246, 245, 244, 243,
                242, 241, 240, 239, 238, 237, 200, 199, 198, 197, 196, 185, 174, 163, 152, 141, 130, 129, 118,
                107, 100, 99, 81, 79, 68, 57, 46, 35, 23, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        for(int x = 0; x < allEightBitBinaryResult.length; x++){
            DecimalToBinary decimalToBinary = new DecimalToBinary(allEightBitBinaryTest[x]);
            //System.out.println("Testing Input: " + allEightBitBinaryTest[x] + " :: " + allEightBitBinaryResult[x]);
            assertEquals(allEightBitBinaryResult[x], decimalToBinary.getResult());
        }
    }

    @Test
    public void testOne(){
        DecimalToBinary decimalToBinary = new DecimalToBinary(255);
        assertEquals("11111111", decimalToBinary.getResult());
    }

}