/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Miguel Rosario
 */
package application;

import java.text.DecimalFormat;
import java.util.*;

public class Solution19 {
    /*
        print: Please enter your weight:
            'weight' = read string from user and convert to double.
                Use try/catch to ensure that input is a double, if not repeat prompt and take input once again.
        print: Please enter your height:
            'height' = read string from user and convert to double.
                Use try/catch to ensure that input is a double, if not repeat prompt and take input once again.
        'bmi' = ('weight' / ('height' * 'height')) * 703
            round to nearest tenth
        print: Your bmi is 'bmi'.
        if 'bmi' >= 18.5 and 'bmi' < 25
            print: You are within the ideal weight range.
        else if 'bmi' < 18.5
            You are underweight. You should see your doctor.
        else
            You are overweight. You should see your doctor.
    */
    private static final Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        Solution19 bmiConsult = new Solution19();
        double weight = bmiConsult.promptUserForMeasurement("weight (pounds)");
        double height = bmiConsult.promptUserForMeasurement("height (inches)");
        double bmi = bmiConsult.bmiCalculator(weight, height);
        bmiConsult.displayBMIResult(bmi);
    }

    private double getDouble(String prompt) { // Method to get and error check a double, prints a user given question.
        double result = 0;
        boolean invalidDouble;
        do {
            invalidDouble = false;
            try {
                System.out.print(prompt);
                result = input.nextDouble();
            }catch(InputMismatchException e) {
                invalidDouble = true;
                input.nextLine();  // Clears out keyboard buffer.
            }
        }while (invalidDouble);
        return result;
    }

    public double bmiCalculator(double weight, double height) {
        double bmi = (weight / (height * height)) * 703;
        return Math.round(bmi * 100) / 100.0;
    }

    public double promptUserForMeasurement(String measurementSearchingFor) {
        String prompt = "Please enter your " + measurementSearchingFor + ": ";
        double userMeasurement;
        do {
            userMeasurement = getDouble(prompt);
        } while(userMeasurement <= 0);
        return userMeasurement;
    }

    public void displayBMIResult(double bmi) {
        DecimalFormat df = new DecimalFormat("0.#");
        String bmiResult;
        bmiResult = "Your BMI is " + df.format(bmi) + ".\n";
        if(bmi >= 18.5 && bmi < 25) {
            bmiResult += "You are within the ideal weight range.";
        } else if(bmi < 18.5) {
            bmiResult += "You are underweight. You should see your doctor.";
        } else {
            bmiResult += "You are overweight. You should see your doctor.";
        }
        System.out.println(bmiResult);
    }

}

