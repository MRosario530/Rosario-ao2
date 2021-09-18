/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 first_name last_name
 */
package solution;

import java.text.DecimalFormat;
import java.util.*;

public class Solution09 {
    /*
        'paintGallonArea' = 350
        print: What is the length of the room in feet?
            'length' = read string from user and convert to double.
        print: What is the width of the room in feet?
            'width' = read string from user and convert to double.
        'squareFt' = 'length' * 'width'
        'gallonsNeeded' = 'squareFt' / 'paintGallonArea'
            round 'gallonsNeeded' up to the nearest integer.
        print: You will need to purchase 'gallonsNeeded' gallons of paint to cover 'squareFt' square feet.
    */
    private static final Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        Solution09 paintCalculator = new Solution09();
        int paintGallonArea = 350;
        double length = paintCalculator.gatherDimension("length");
        double width = paintCalculator.gatherDimension("width");
        double squareFt = paintCalculator.calculateArea(length,width);
        int gallonsNeeded = paintCalculator.calculatePaint(squareFt, paintGallonArea);
        paintCalculator.printPaint(squareFt, gallonsNeeded);
    }

    public double gatherDimension(String dimension) {
        System.out.print("What is the " + dimension + " of the room in feet? ");
        String currentString = input.nextLine();
        return Double.parseDouble(currentString);
    }

    public double calculateArea(double length, double width) {
        return length * width;
    }

    public int calculatePaint(double squareFt, int paintGallonArea) {
        double amtOfPaint = squareFt/paintGallonArea;
        return (int)Math.ceil(amtOfPaint);
    }

    public void printPaint(double squareFt, int gallonsNeeded) {
        DecimalFormat df = new DecimalFormat("#.##");
        String printPaint = "You will need to purchase " + gallonsNeeded + " gallons of paint to cover " + df.format(squareFt) + " square feet.";
        System.out.println(printPaint);
    }
}