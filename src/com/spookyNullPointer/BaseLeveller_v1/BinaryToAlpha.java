package com.spookyNullPointer.BaseLeveller_v1;

class BinaryToAlpha {

    String input;
    LetterDets[] letterDetsArray = new LetterDets[53];

    BinaryToAlpha(String input){
        this.input = input;
        createLetterDetsArray();
    }

    private String binaryToLetter(String binaryLetter, boolean returnLetter) {

        String letter = "Error";
        String asciiValue = "Error";
        if(binaryLetter.equals(" ")){
            binaryLetter = "00100000";
        }
            for (int x = 0; x < letterDetsArray.length; x++) {
                if (letterDetsArray[x].getBinary().equals(binaryLetter)) {
                    letter = letterDetsArray[x].getLetter();
                    asciiValue = letterDetsArray[x].getASCII();
                    break;
                }
            }
        if(returnLetter){
            return letter;
        } else {
            return asciiValue;
        }
    }

    public String getResultAlpha() {
        return binaryToAlpha();
    }

    private String[] binaryToBinaryArray(String binaryString) {

        String[] holdTempLetter = new String[8];
        int countNonSpaces = 0;
        int numberOfLetters = 0;
        int countOutputInputs = 0;

        //Count how many non white space characters
        for (int x = 0; x < binaryString.length(); x++) {
            if(!Character.isWhitespace(binaryString.charAt(x))) {
                countNonSpaces++;
            }
        }

        //Count how many 8bit strings (should be divisible by 8)
        if (countNonSpaces % 8 == 0) {
            numberOfLetters = countNonSpaces / 8;
        } else {
            System.out.println("Error: BinaryToAlpha - Letter Count Non-Divisible");
            System.exit(-1);
        }

        String[] outputString = new String[numberOfLetters];
        int counter = 0;
        for (int x = 0; x < binaryString.length(); x++) {

            if (!Character.isWhitespace(binaryString.charAt(x))) {
                if (counter <= 7) {
                    holdTempLetter[counter] = Character.toString(binaryString.charAt(x));
                    counter++;
                }
            }
            else {
                counter = 0;
                StringBuilder builder = new StringBuilder();
                for(String s : holdTempLetter) {
                    builder.append(s);
                }
                outputString[countOutputInputs] = builder.toString();
                countOutputInputs++;
                holdTempLetter = new String[8];
            }
        }
        StringBuilder builder = new StringBuilder();
        for(String s : holdTempLetter) {
            builder.append(s);
        }
        outputString[countOutputInputs] = builder.toString();
        return outputString;
    }

    private String binaryArrayToAlpha(String[] binaryStringArray){

        String[] holdAlphas = new String[binaryStringArray.length];
        for(int x = 0; x < binaryStringArray.length; x++){
            holdAlphas[x] = binaryToLetter(binaryStringArray[x], true);
        }

        StringBuilder builder = new StringBuilder();
        for(String s : holdAlphas) {
            builder.append(s);
        }

        return builder.toString();
    }

    private String binaryToAlpha(){

        if(input.length() <= 8){
            return binaryToLetter(input, true);
        }
        else if(input.length() > 8) {
            return binaryArrayToAlpha(binaryToBinaryArray(input));
        }
        else {
            System.out.println("Error: Binary Size in binaryToAlpha");
            return "Error";
        }
    }

    private void createLetterDetsArray() {

        String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ ";
        String[] binaryValues = new String[]{"01100001", "01100010", "01100011", "01100100", "01100101",
                "01100110", "01100111", "01101000", "01101001", "01101010", "01101011", "01101100",
                "01101101", "01101110", "01101111", "01110000", "01110001", "01110010", "01110011",
                "01110100", "01110101", "01110110", "01110111", "01111000", "01111001", "01111010",
                "01000001", "01000010", "01000011", "01000100", "01000101", "01000110", "01000111",
                "01001000", "01001001", "01001010", "01001011", "01001100", "01001101", "01001110",
                "01001111", "01010000", "01010001", "01010010", "01010011", "01010100", "01010101",
                "01010110", "01010111", "01011000", "01011001", "01011010", "00100000"};
        String[] asciiValues = new String[]{"097", "098", "099", "100", "101", "102", "103", "104", "105", "106",
                "107", "108", "109", "110", "111", "112", "113", "114", "115", "116", "117", "118", "119", "120",
                "121", "122", "065", "066", "067", "068", "069", "070", "071", "072",
                "073", "074", "075", "076", "077", "078", "079", "080", "081", "082", "083", "084", "085",
                "086", "087", "088", "089", "090", "032"};

        for (int x = 0; x < letterDetsArray.length; x++) {
            letterDetsArray[x] = new LetterDets(Character.toString(alphabet.charAt(x)), asciiValues[x], binaryValues[x]);
        }
    }
}
