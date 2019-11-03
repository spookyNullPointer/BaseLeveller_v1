package com.spookyNullPointer.BaseLeveller_v1;

import java.util.Scanner;

//TODO: Do another Conversion Loop / Exit
//TODO: Binary to Text can only do single letters (8 bits of Binary)
//TODO: Errors don't re-start menu
//TODO: Incorrect input loop doesn't work
//TODO: Unable to paste into cmd, runs and errors
//TODO: Input "-1" to return to menu

class Main{

    //App Info
    static final double VERSION = 1.0;

    //App Globals
    String lastConversion;
    int numberOfMenuChoices = 4;
    Scanner userInput;
    String userInputString;
    String userInputText;
    int userInputInt;
    int incorrectInputCount = 0;

    public Main(){
        switch(getMenuInput()){
            case 1:
                lastConversion = "Binary to Decimal";
                getUserInputBinary(false);
                convertBinaryToDecimal();
                break;
            case 2:
                lastConversion = "Decimal to Binary";
                getUserInputInt();
                convertDecimalToBinary();
                break;
            case 3:
                lastConversion = "Binary to Text";
                getUserInputBinary(true);
                convertBinaryToText();
                break;
            case 4:
                lastConversion = "Text to Binary";
                getUserInputText();
                convertTextToBinary();
                break;
        }
    }

    private int getMenuInput(){
        printHeading();
        sysPrint("Welcome to BaseLeveller");
        sysPrint("Please select conversion you'd like to carry out: ");
        sysPrint("Option 1: Binary To Decimal");
        sysPrint("Option 2: Decimal To Binary");
        sysPrint("Option 3: Binary To Text");
        sysPrint("Option 4: Text To Binary");
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
        //System.out.println("Debug: Menu Input :: " + menuChoice);
        return menuChoice;
    }

    private void getUserInputBinary(boolean isForLetterBinary) {
        userInput = new Scanner(System.in);
        System.out.println("Input Binary To Convert: ");
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

    private void getUserInputInt(){
        userInput = new Scanner(System.in);
        System.out.println("Input Integer To Convert (0 to 255): ");
        userInputInt = userInput.nextInt();
        if(!validateInt(0, 255, userInputInt) && incorrectInputCount <= 3){
            getUserInputInt();
            incorrectInputCount++;
        }
        if(incorrectInputCount >= 3){
            sysPrint("exceedMaxUserInput");
            System.exit(-1);
        }
    }

    private void getUserInputText(){
        userInput = new Scanner(System.in);
        System.out.println("Input Text: ");
        userInputText = userInput.nextLine();
        if(!validateText(userInputText) && incorrectInputCount <= 3){
            getUserInputText();
            incorrectInputCount++;
        }
        if(incorrectInputCount >= 3){
            sysPrint("exceedMaxUserInput");
            System.exit(-1);
        }
    }

    private boolean validateInt(int min, int max, int userInputInt){

        boolean isValid = true;
        if(userInputInt > max){
            errorPrinter("maxIntInput");
            isValid = false;
        }
        else if(userInputInt < min){
            errorPrinter("minIntInput");
            isValid = false;
        }
        return isValid;
    }

    private boolean validateMenuChoice(int menuChoice){
        if((menuChoice > numberOfMenuChoices) || (menuChoice < 1)){
            return false;
        }
        else{
            return true;
        }
    }

    private boolean validateText(String userInputText){

        boolean isValid = false;
        String acceptedValues = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ ";
        for(int x = 0; x < userInputText.length(); x++){
            for(int y = 0; y < acceptedValues.length(); y++) {
                if(userInputText.charAt(x) == acceptedValues.charAt(x)){
                    isValid = true;
                }
            }
        }
        return isValid;
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
            case "minIntInput":
                sysPrint("Error: Min Value 0");
                break;
            case "maxIntInput":
                sysPrint("Error:  Max Value 255");
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

    private void convertBinaryToDecimal(){

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
            runAgain();
        }
    }

    private void convertBinaryToText(){

        BinaryToAlpha binaryToAlpha = new BinaryToAlpha(userInputString);
        if(binaryToAlpha.getResultAlpha().equals("Error")){
            errorPrinter("convertError");
            incorrectInputCount = 0;
            getUserInputBinary(true);
        }
        else {
            sysPrint("Binary value: " + userInputString);
            sysPrint("Alphabetic value: " + binaryToAlpha.getResultAlpha());
            runAgain();
        }
    }

    private void convertDecimalToBinary(){

        if((userInputInt > 255) || (userInputInt < 0)){
            errorPrinter("minMaxIntInput");
            incorrectInputCount = 0;
            getUserInputBinary(false);
        }
        DecimalToBinary decimalToBinary = new DecimalToBinary(userInputInt);
        sysPrint("Binary value: " + userInputInt);
        sysPrint("Alphabetic value: " + decimalToBinary.getResult());
        runAgain();
    }

    private void convertTextToBinary(){
        AlphaToBinary alphaToBinary = new AlphaToBinary(userInputText);
        if(alphaToBinary.getResult().equals("Error")){
            errorPrinter("convertError");
            incorrectInputCount = 0;
            getUserInputText();
        }
        else {
            sysPrint("Binary value: " + userInputString);
            sysPrint("Alphabetic value: " + alphaToBinary.getResult());
            runAgain();
        }
    }

    private void runAgain(){
        userInput = new Scanner(System.in);
        sysPrint("Do Another " + lastConversion + "Conversion?");
        sysPrint("Y / N");
        String runAgainChoice = userInput.nextLine();
        if(!runAgainUserInputValidate(runAgainChoice) && incorrectInputCount >= 3){
            errorPrinter("invalidInput");
            incorrectInputCount++;
            runAgain();
        }
        else if(runAgainChoice.equals("Y") || runAgainChoice.equals("y") ){
            incorrectInputCount = 0;
            new Main();
        }
        else if(runAgainChoice.equals("N") || runAgainChoice.equals("n")){
            sysPrint("Exiting Application...");
            System.exit(-1);
        }
    }

    private boolean runAgainUserInputValidate(String userInput){
        boolean isValid = false;
        if(userInput.equals("Y") || userInput.equals("N") || userInput.equals("n") || userInput.equals("y")){
            isValid = true;
        }
        return isValid;
    }

    public static void main(String[] args){
        new Main();
    }
}
