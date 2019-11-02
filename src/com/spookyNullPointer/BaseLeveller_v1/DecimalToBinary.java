package com.spookyNullPointer.BaseLeveller_v1;

class DecimalToBinary {

    int input;
    int[] binaryValues = new int[]{128, 64, 32, 16, 8, 4, 2, 1};


    DecimalToBinary(int input){
        this.input = input;
    }

    private String convertIntToBinary(int input){

        String[] binaryString = new String[8];

        for(int x = 0; x < binaryValues.length; x++){
            if(input >= binaryValues[x]){
                input = input - binaryValues[x];
                binaryString[x] = "1";
            }
            else {
                binaryString[x] = "0";
            }
        }
        StringBuilder builder = new StringBuilder();
        for(String s : binaryString) {
            builder.append(s);
        }

        return builder.toString();
    }

    public String getResult(){
        return convertIntToBinary(input);
    }
}
