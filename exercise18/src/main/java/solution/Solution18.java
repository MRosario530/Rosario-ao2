/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Miguel Rosario
 */
package solution;

import java.text.DecimalFormat;
import java.util.*;

public class Solution18 {
    /*
        print: Press C to convert from Fahrenheit to Celsius:
        print: Press F to convert from Celsius to Fahrenheit.
            'conversionDirection' = read string from user and convert to char (capitalize the char).
                if the char does not equal C or F prompt the user again for 'conversionDirection'.
        if 'conversionDirection' == 'C'
            print: Please enter the temperature in Fahrenheit.
        else
            print: Please enter the temperature in Celsius.
        'unconvertedTemperature' = read string from user and convert to double.
        if 'conversionDirection' == 'C'
            'convertedTemperature' = ('unconvertedTemperature' - 32) * (5 / 9)
            print: The temperature in Celsius is 'convertedTemperature'.
        else
            'convertedTemperature' = ('unconvertedTemperature' * (9 / 5)) + 32
            print: The temperature in Fahrenheit is 'convertedTemperature'.
    */
    private static final Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        Solution18 tempConverter = new Solution18();
        char temperatureConversionDirection = tempConverter.getTemperatureConversionDirection();
        double convertedTemperature = tempConverter.getTemperature(temperatureConversionDirection);
        tempConverter.printConvertedTemperature(temperatureConversionDirection, convertedTemperature);
    }

    private char getChar(String prompt) { // Method to get and error check a char.
        char letter;
        String userInput;
        do {
            System.out.print(prompt);
            userInput = input.nextLine();
        } while (userInput.length() != 1);
        userInput = userInput.toUpperCase();
        letter = userInput.charAt(0);
        return letter;
    }

    private void promptForTemperatureConversion(char tempLetter, String temperatureFrom, String temperatureTo) {
        System.out.println("Press " + tempLetter + " to convert from " + temperatureFrom + " to " + temperatureTo + ".");
    }

    private char getTemperatureConversionDirection() {
        char tempChar;
        promptForTemperatureConversion('C', "Fahrenheit", "Celsius");
        promptForTemperatureConversion('F', "Celsius", "Fahrenheit");
        do {
            tempChar = getChar("Your choice: ");
        } while(tempChar != 'C' && tempChar != 'F'); // getChar capitalizes user input to avoid case disparities
        return tempChar;
    }

    public double getTemperature(char temperatureConversionDirection) {
        // Prompts the user for the temperature they are converting from before calling the conversion calculator
        // which returns the final converted value through this method.
        String prompt = "Please enter the temperature in ";
        if(temperatureConversionDirection == 'C') {
            prompt += "Fahrenheit: ";
        } else {
            prompt += "Celsius: ";
        }
        System.out.print(prompt);
        String unconvertedTempString = input.nextLine();
        double unconvertedTemperature = Double.parseDouble(unconvertedTempString);
        return temperatureCalculator(temperatureConversionDirection, unconvertedTemperature);
    }

    public double temperatureCalculator(char tempConversionDirection, double unconvertedTemperature) {
        double result;
        if(tempConversionDirection == 'C') {
            result = (unconvertedTemperature - 32) * (5.0 / 9.0);
        }else {
            result = (unconvertedTemperature * (9.0 / 5.0)) + 32;
        }
        return Math.round(result * 100) / 100.0;
    }

    private void printConvertedTemperature(char tempConversionDirection, double convertedTemperature) {
        DecimalFormat df = new DecimalFormat("0.#");
        String prompt = "The temperature in ";
        if(tempConversionDirection == 'C') {
            prompt += "Celsius is ";
        } else {
            prompt += "Fahrenheit is ";
        }
        prompt += df.format(convertedTemperature) + ".";
        System.out.println(prompt);
    }
}