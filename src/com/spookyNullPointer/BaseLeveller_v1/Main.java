package com.spookyNullPointer.BaseLeveller_v1;

import java.util.Scanner;

public class Main {

    //TODO: Maven Build File
    //TODO: JUnit Tests BinaryToDecimal
    //TODO: DecimalToBinary
    //TODO: TextToBinary

    //TODO: BinaryToText - One Word
    //TODO: BinaryToText - Multiple Words

    //TODO: HexToDecimal
    //TODO: DecimalToHex


    int numberOfMenuChoices = 4;
    Scanner userInput;
    String userInputString;
    int incorrectInputCount = 0;

    Main(){

        switch(getMenuInput()){
            case 1:
                getUserInputBinary(false);
                convertBinaryToDecimal(userInputString);
                break;
            case 2:
                System.out.println("UNAVAILABLE");
                System.exit(-1);
                break;
            case 3:
                getUserInputBinary(true);
                convertBinaryToText(userInputString);
                break;
            case 4:
                break;

        }

    }

    private int getMenuInput(){
        printHeading();
        sysPrint("Welcome to BaseLeveller");
        sysPrint("Please select conversion you'd like to carry out: ");
        sysPrint("Option 1: Binary To Decimal");
        sysPrint("Option 2: Decimal To Binary UNAVAILABLE");
        sysPrint("Option 3: Binary To Text");
        sysPrint("Option 4: Text To Binary UNAVAILABLE");
        sysPrint("Option 5: Binary to ASCII UNAVAILABLE");
        sysPrint("Option 6: ASCII to Binary UNAVAILABLE");
        System.out.print("Input Choice: ");
        userInput = new Scanner(System.in);
        int menuChoice = userInput.nextInt();

        if(!validateMenuChoice(menuChoice) && incorrectInputCount <= 3){
            sysPrint("invalidInput " + (3 - incorrectInputCount));
            getMenuInput();
        }
        if(incorrectInputCount >= 3){
            sysPrint("exceedMaxUserInput");
            System.exit(-1);
        }

        System.out.println("Debug: Menu Input :: " + menuChoice);
        return menuChoice;
    }


    private void getUserInputBinary(boolean isForLetterBinary) {
        System.out.println("Debug: Enter UserInputBinary");
        userInput = new Scanner(System.in);
        System.out.println("69Input Binary To Convert: ");
        userInputString = userInput.nextLine();
        if (!validateBinary(userInputString, isForLetterBinary) && incorrectInputCount <= 3) {
            getUserInputBinary(isForLetterBinary);
            incorrectInputCount++;
        }
        if(incorrectInputCount >= 3){
            sysPrint("exceedMaxUserInput");
            System.exit(-1);
        }
    }

    private boolean validateMenuChoice(int menuChoice){
        if((menuChoice > numberOfMenuChoices) || (menuChoice < 1)){
            return false;
        }
        else{
            return true;
        }
    }

    private boolean validateBinary(String userInput, boolean letterBinary){

        boolean isValid = true;

        //Check Min / Max Size
        if(userInputString.length() == 0) {
            errorPrinter("maxStringLength");
            isValid = false;
        }
        else if(userInputString.length() > 8){
            errorPrinter("maxStringLength");
            isValid = false;
        }

        //Check all 0 / 1 Values
        for(int x = 0; x < userInputString.length(); x++){
            if((userInputString.charAt(x) != '1')){
                if ((userInputString.charAt(x) != '0')) {
                    sysPrint("Checking: " + userInputString.charAt(x));
                    errorPrinter("invalidInput");
                    isValid = false;
                }
            }
        }

        //If Binary represents letter, must be 8 bits
        if(letterBinary){
            if(userInput.length() != 8){
                isValid = false;
            }
        }
        return isValid;
    }

    private void errorPrinter(String errorType){
        switch(errorType) {
            case "invalidInput":
                sysPrint("Error: Input Invalid");
                break;
            case "minStringLength":
                sysPrint("Error: Minimum input size: 1");
                break;
            case "maxStringLength":
                sysPrint("Error: Maximum input size: 8");
                break;
            case "exceedMaxUserInput":
                sysPrint("Exceed Max Input Attempts: System Exit");
                break;
            case "convertError":
                sysPrint("Error: A conversion error occurred, try again");
                break;
        }
    }

    private void sysPrint(String toPrint){
        System.out.println(toPrint);
    }

    private void printHeading(){
        sysPrint("  ____                   _                    _ _           ");
        sysPrint(" |  _ \\                 | |                  | | |          ");
        sysPrint(" | |_) | __ _ ___  ___  | |     _____   _____| | | ___ _ __ ");
        sysPrint(" |  _ < / _` / __|/ _ \\ | |    / _ \\ \\ / / _ \\ | |/ _ \\ '__|");
        sysPrint(" | |_) | (_| \\__ \\  __/ | |___|  __/\\ V /  __/ | |  __/ |   ");
        sysPrint(" |____/ \\__,_|___/\\___| |______\\___| \\_/ \\___|_|_|\\___|_|  ");
        sysPrint("                                       By spookyNullPointer");
    }

    private void convertBinaryToDecimal(String userInputString){
        System.out.println("Debug: Enter BinaryToDecimal");
        BinaryToDecimal binaryToDecimal = new BinaryToDecimal(userInputString);

        //Internal Error
        if(binaryToDecimal.getResult() == -1){
            errorPrinter("convertError" + "1");
            incorrectInputCount = 0;
            getUserInputBinary(false);
        }
        //Result of Conversion
        else if(binaryToDecimal.getResult() > -1){

            sysPrint("Binary value: " + userInputString);
            sysPrint("Decimal value: " + binaryToDecimal.getResult());
        }
    }

    private void convertBinaryToText(String userInputString){
        //TODO: Implement Space Search for Text
        //TODO: Punctuation
        BinaryToAlpha binaryToAlpha = new BinaryToAlpha(userInputString);

        if(binaryToAlpha.getResultLetter().equals("@")){
            errorPrinter("convertError" + "2");
            incorrectInputCount = 0;
            getUserInputBinary(true);
        }
        else {
            sysPrint("Binary value: " + userInputString);
            sysPrint("Alphabetic value: " + binaryToAlpha.getResultLetter());
        }
    }

    public static void main(String[] args){
        new Main();
    }
}
