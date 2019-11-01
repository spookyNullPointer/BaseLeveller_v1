package com.spookyNullPointer.BaseLeveller_v1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryToAlphaTest {

    //TODO: Tests to Fail - Acceptance testing

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
    public void testAlphaUpper(){

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

    @Test
    public void testCompleteStringAlpha(){
        String[] completeStrings = new String[]{"this is a test string", "THIS IS A TEST STRING",
                "ThIs Is A tEsT sTrIng", "a b c d e f g h i j k l m n o p q r s t u v w x y z", "short",
                "llloooooonnnnnggggg"};

        String[] completeStringsResults = new String[]{"01110100 01101000 01101001 01110011 " +
                "00100000 01101001 01110011 00100000 01100001 00100000 01110100 01100101 01110011 " +
                "01110100 00100000 01110011 01110100 01110010 01101001 01101110 01100111", "01010100 " +
                "01001000 01001001 01010011 00100000 01001001 01010011 00100000 01000001 00100000 01010100 " +
                "01000101 01010011 01010100 00100000 01010011 01010100 01010010 01001001 01001110 01000111",
                "01010100 01101000 01001001 01110011 00100000 01001001 01110011 00100000 01000001 00100000 " +
                        "01110100 01000101 01110011 01010100 00100000 01110011 01010100 01110010 01001001 " +
                        "01101110 01100111", "01100001 00100000 01100010 00100000 01100011 00100000 01100100 " +
                "00100000 01100101 00100000 01100110 00100000 01100111 00100000 01101000 00100000 01101001 " +
                "00100000 01101010 00100000 01101011 00100000 01101100 00100000 01101101 00100000 01101110 " +
                "00100000 01101111 00100000 01110000 00100000 01110001 00100000 01110010 00100000 01110011 " +
                "00100000 01110100 00100000 01110101 00100000 01110110 00100000 01110111 00100000 01111000 " +
                "00100000 01111001 00100000 01111010", "01110011 01101000 01101111 01110010 01110100", "01101100 " +
                "01101100 01101100 01101111 01101111 01101111 01101111 01101111 01101111 01101110 01101110 " +
                "01101110 01101110 01101110 01100111 01100111 01100111 01100111 01100111"};

        for(int x = 0; x < completeStrings.length; x++){
            BinaryToAlpha binaryToAlpha = new BinaryToAlpha(completeStrings[x]);
            assertEquals(completeStringsResults[x], binaryToAlpha.getResultAlpha());
        }
    }

    @Test
    public void testCompleteStringASCII(){
        String[] completeStrings = new String[]{"this is a test string", "THIS IS A TEST STRING",
                "ThIs Is A tEsT sTrIng", "a b c d e f g h i j k l m n o p q r s t u v w x y z", "short",
                "llloooooonnnnnggggg"};

        String[] completeStringsResults = new String[]{"116 104 105 115 032 105 115 032 097 " +
                "032 116 101 115 116 032 115 116 114 105 110 103", "084 072 073 083 032 073 " +
                "083 032 065 032 084 069 083 084 032 083 084 082 073 078 071",  };

        for(int x = 0; x < completeStrings.length; x++){
            BinaryToAlpha binaryToAlpha = new BinaryToAlpha(completeStrings[x]);
            assertEquals(completeStringsResults[x], binaryToAlpha.getResultASCII());
        }
    }

}