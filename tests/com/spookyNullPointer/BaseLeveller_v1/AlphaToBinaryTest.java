package com.spookyNullPointer.BaseLeveller_v1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlphaToBinaryTest {

    @Test
    public void testAlphaInput(){
        AlphaToBinary alphaToBinary = new AlphaToBinary("01110100 01100101 01110011 01110100 01101001 01101110 01100111 " +
                "00100000 01110100 01101000 01101001 01110011 00100000 01110011 01110100 01110010 01101001 01101110 01100111");
        assertEquals("testing this string", alphaToBinary.getResult());
    }

}