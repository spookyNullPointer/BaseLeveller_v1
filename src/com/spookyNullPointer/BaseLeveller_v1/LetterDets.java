package com.spookyNullPointer.BaseLeveller_v1;

public class LetterDets {

    String letter;
    String ASCII, binary;

    LetterDets(String letter, String ASCII, String binary){
        this.letter = letter;
        this.ASCII = ASCII;
        this.binary = binary;
    }

    public String getLetter(){
        return letter;
    }
    public String getASCII(){
        return ASCII;
    }
    public String getBinary(){
        return binary;
    }


}
