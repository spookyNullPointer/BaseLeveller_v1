package com.spookyNullPointer.BaseLeveller_v1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlphaToBinaryTest {

    @Test
    public void testAlphaInput(){
        AlphaToBinary alphaToBinary = new AlphaToBinary("testing this string");
        assertEquals("01110100 01100101 01110011 01110100 01101001 01101110 01100111 " +
                "00100000 01110100 01101000 01101001 01110011 00100000 01110011 01110100 01110010 " +
                "01101001 01101110 01100111", alphaToBinary.getResult());
    }

    @Test
    public void testAlphaInput2(){
        AlphaToBinary alphaToBinary = new AlphaToBinary("RaNdOm SSSSTTrrInG oF UpPER aND LoWER");
        assertEquals("01010010 01100001 01001110 01100100 01001111 01101101 00100000 01010011 " +
                "01010011 01010011 01010011 01010100 01010100 01110010 01110010 01001001 01101110 01000111 " +
                "00100000 01101111 01000110 00100000 01010101 01110000 01010000 01000101 01010010 00100000 " +
                "01100001 01001110 01000100 00100000 01001100 01101111 01010111 01000101 " +
                "01010010", alphaToBinary.getResult());
    }

    @Test
    public void testAlphaInput3(){
        AlphaToBinary alphaToBinary = new AlphaToBinary("Sentence can not have any punctuation ");
        assertEquals("01010011 01100101 01101110 01110100 01100101 01101110 01100011 01100101 00100000 " +
                "01100011 01100001 01101110 00100000 01101110 01101111 01110100 00100000 01101000 01100001 01110110 " +
                "01100101 00100000 01100001 01101110 01111001 00100000 01110000 01110101 01101110 01100011 01110100 " +
                "01110101 01100001 01110100 01101001 01101111 01101110 00100000", alphaToBinary.getResult());
    }



}