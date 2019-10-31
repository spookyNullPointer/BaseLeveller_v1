package com.spookyNullPointer.BaseLeveller_v1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryToAlphaTest {

    @Test
    public void testAlphaLower() throws Exception{

        String[] binaryValuesToTest = new String[]{"01100001", "01100010", "01100011", "01100100", "01100101",
                "01100110", "01100111", "01101000", "01101001", "01101010", "01101011", "01101100",
                "01101101", "01101110", "01101111", "01110000", "01110001", "01110010", "01110011",
                "01110100", "01110101", "01110110", "01110111", "01111000", "01111001", "01111010"};

        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        for(int x = 0; x < binaryValuesToTest.length; x++){
            BinaryToAlpha binaryToAlpha = new BinaryToAlpha(binaryValuesToTest[x]);
            assertEquals(Character.toString(alphabet.charAt(x)), binaryToAlpha.getResultLetter());
        }
    }

    @Test
    public void testAlphaUpper() throws Exception{

        String[] binaryValuesToTest = new String[]{"01000001", "01000010", "01000011", "01000100", "01000101", "01000110", "01000111",
                "01001000", "01001001", "01001010", "01001011", "01001100", "01001101", "01001110",
                "01001111", "01010000", "01010001", "01010010", "01010011", "01010100", "01010101",
                "01010110", "01010111", "01011000", "01011001", "01011010"};

        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        for(int x = 0; x < binaryValuesToTest.length; x++){
            BinaryToAlpha binaryToAlpha = new BinaryToAlpha(binaryValuesToTest[x]);
            assertEquals(Character.toString(alphabet.charAt(x)), binaryToAlpha.getResultLetter());
        }
    }

}