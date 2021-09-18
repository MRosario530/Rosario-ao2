/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Miguel Rosario
 */
package solution;

import java.text.DecimalFormat;
import java.util.*;

public class Solution17 {
    /*
        print: Enter a 1 is you are male or a 2 if you are female:
            'gender' = read string from user and convert to int
                use try/catch to ensure value entered is numeric, repeat if gender is not numeric or does not equal
                1 or 2.
        print: How many ounces of alcohol did you have?
            'ouncesOfAlcohol' = read string from user and convert to double.
                use try/catch to ensure value entered is numeric, repeat call for ouncesOfAlcohol otherwise.
        print: What is your weight, in pounds?
            'weight' = read string from user and convert to double.
                use try/catch to ensure value entered is numeric, repeat call for weight otherwise.
        print: How many hours has it been since your last drink?
            'hoursSinceDrink' = read string from user and convert to double.
                use try/catch to ensure value entered is numeric, repeat call for 'hoursSinceDrink' otherwise.
        if 'gender' == 1
            'alcDisRatio' = 0.73
        else
            'alcDisRatio' = 0.66
        'bac' = ('ouncesOfAlcohol' * 5.14 / 'weight' * 'alcDisRatio') - 0.015 * 'hoursSinceDrink'
        print: Your BAC is 'bac'
        if 'bac' >= 0.08
            print: It is not legal for you to drive.
        else
            print: It is legal for you to drive.
   */
    private static final Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        Solution17 calculator = new Solution17();
        double[] userAlcoholInfo = calculator.collectUserInfo();
        double bloodAlcoholContent = calculator.calculateBAC(userAlcoholInfo);
        calculator.displayResult(bloodAlcoholContent);
    }

    private int getInt(String ques) { // Method to get and error check an integer, prints a user given question.
        int result = 0;
        boolean invalidInt;
        do {
            invalidInt = false;
            try {
                do {
                    System.out.print(ques);
                    result = input.nextInt();
                }while(result <= 0);
            }catch(InputMismatchException e) {
                invalidInt = true;
                input.nextLine();  //Clears out keyboard buffer.
            }
        }while(invalidInt);
        return result;
    }

    private double getDouble(String ques) { // Method to get and error check a double, prints a user given question.
        double result = 0;
        boolean invalidDouble;
        do {
            invalidDouble = false;
            try {
                do {
                    System.out.print(ques);
                    result = input.nextDouble();
                }while(result <= 0);
            }catch(InputMismatchException e) {
                invalidDouble = true;
                input.nextLine();  // Clears out keyboard buffer.
            }
        }while (invalidDouble);
        return result;
    }

    public double[] collectUserInfo() {
        // Stores all user given values (gender, ounces of alcohol, weight, and hours in a double array).
        double[] userInfo = new double[4];
        do {
            userInfo[0] = getInt("Enter a 1 is you are male or a 2 if you are female: ");
        } while(userInfo[0] != 1 && userInfo[0] != 2);
        userInfo[1] = getDouble("How many ounces of alcohol did you have? ");
        userInfo[2] = getDouble("What is your weight, in pounds? ");
        userInfo[3] = getDouble("How many hours has it been since your last drink? ");
        return userInfo;
    }

    public double calculateBAC(double[] userInfo) {
        double alcDisRatio;
        if(userInfo[0] == 1) {
            alcDisRatio = 0.73;
        }else {
            alcDisRatio = 0.66;
        }
        return (userInfo[1] * 5.14 / userInfo[2] * alcDisRatio) - 0.015 * userInfo[3];
    }

    public void displayResult(double bac) {
        DecimalFormat df = new DecimalFormat("0.######");
        String displayBAC = "Your BAC is " + df.format(bac);
        if(bac >= 0.08 ) {
            displayBAC += "\nIt is not legal for you to drive.";
        } else {
            displayBAC += "\nIt is legal for you to drive.";
        }
        System.out.println(displayBAC);
    }
}
