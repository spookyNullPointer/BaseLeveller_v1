package com.spookyNullPointer.BaseLeveller_v1;

class BinaryToDecimal {

    //TODO: Convert to 8 Bit Binary
    //TODO: 128bit Array, Compare
    //TODO: Sum of Binary

    char[] userInputInEightBit;
    int sumDecimalValues = 0;
    String input;

    BinaryToDecimal(String input){
        this.input = input;
        userInputInEightBit = new char[8];
        convertToEightBit();
        convertToDecimal();
    }

    private void convertToEightBit(){

        int counter = 7;
        if(input.length() == 8){
            for(int x = 0; x < input.length(); x++){
                userInputInEightBit[x] = input.charAt(x);
            }
        }
        else {
            for(int x = input.length()-1; x >= 0; x--){
                userInputInEightBit[counter] = input.charAt(x);
                counter--;
            }
            for(int y = counter; y >= 0; y--){
                userInputInEightBit[counter] = '0';
                counter--;
            }
        }
        System.out.println(userInputInEightBit);
    }

    private void convertToDecimal(){
        int[] decimalValues = new int[] {128,64,32,16,8,4,2,1};
        for(int x = 0; x < userInputInEightBit.length; x++){
            if(userInputInEightBit[x] == '1'){
                sumDecimalValues = sumDecimalValues + decimalValues[x];
            }
        }
    }

    public int getResult(){
        return sumDecimalValues;
    }
}

