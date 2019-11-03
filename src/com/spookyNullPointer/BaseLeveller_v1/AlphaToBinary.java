package com.spookyNullPointer.BaseLeveller_v1;

class AlphaToBinary {

    String input;
    LetterDets[] letterDetsArray = new LetterDets[53];

    AlphaToBinary(String input){
        this.input = input;
        createLetterDetsArray();
    }

    private String[] letterToBinary(){

        String[] outputString = new String[input.length()];
        for(int x = 0; x < input.length(); x++){
            for(int y = 0; y < letterDetsArray.length; y++){
                
            }
        }
        for(int x = 0; x < input.length(); x++){
            if(letterDetsArray[x].getLetter().equals(Character.toString(input.charAt(x)))){
                outputString[x] = letterDetsArray[x].getBinary();
            }
        }
        return outputString;
    }

    private String buildString(String[] buildFromArray){

        StringBuilder builder = new StringBuilder();
        for(String s : buildFromArray) {
            builder.append(s);
        }
        return builder.toString();
    }



    public String getResult(){
        return buildString(letterToBinary());
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
