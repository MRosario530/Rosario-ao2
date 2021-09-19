/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Miguel Rosario
 */
package application;

import java.text.DecimalFormat;
import java.util.*;

public class Solution22 {
    /*
        'values': create an array of doubles to hold user inputted numbers.
        print: Enter the first number:
            'values'[0] = read string from user and convert to double.
        print: Enter the second number:
            'values'[1] = read string from user and convert to double.
        print: Enter the third number:
            'values'[2] = read string from user and convert to double.
        'tempNum' = 'values'[0]
        'largestNum' = 'values'[0]
        'sameNumbers' = true
        for i = 0; i < 3; i++
            if 'values'[i] != 'tempNum'
                'sameNumbers' = false
            if 'values'[i] > 'largestNum'
                'largestNum' = 'values'[i]
        if 'sameNumbers' == false
            print: The largest number is 'largestNum'
    */
    private static final Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        Solution22 numbersOrganizer = new Solution22();
        double[] numbersArray = numbersOrganizer.userInputArray();
        numbersOrganizer.determineGreatestValue(numbersArray);
    }

    private double getDouble(String ques) { // Method to get and error check a double, prints a user given question.
        double result = 0;
        boolean invalidDouble;
        do {
            invalidDouble = false;
            try {
                System.out.print(ques);
                result = input.nextDouble();
            } catch(InputMismatchException e) {
                invalidDouble = true;
                input.nextLine();  // Clears out keyboard buffer.
            }
        }while (invalidDouble);
        return result;
    }

    public double[] userInputArray(){
        // Stores the 3 user inputted numbers as an array and return the array.
        double[] numArray = new double[3];
        numArray[0] = getDouble("Enter the first number: ");
        numArray[1] = getDouble("Enter the second number: ");
        numArray[2] = getDouble("Enter the third number: ");
        return numArray;
    }

    public void determineGreatestValue(double []numArray) {
        DecimalFormat df = new DecimalFormat("#.###");
        boolean noDuplicates = true;
        double largestValue = numArray[0];
        for(int i = 0; i < 2; i++) {
            if(numArray[i] != numArray[i+1]) {
                noDuplicates = false;
            }
            if(numArray[i+1] > largestValue) {
                largestValue = numArray[i+1];
            }
        }
        if(!noDuplicates) {
            System.out.println("The largest value is " + df.format(largestValue) + ".");
        }
    }
}
