/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Miguel Rosario
 */
package solution;

import java.text.DecimalFormat;
import java.util.*;

public class Solution07 {
    /*
         'conversionFactor' = 0.09290304
         print: What is the length of the room in feet?
             'length' = read string from user and convert to double.
          print: What is the width of the room in feet?
             'width' = read string from user and convert to double.
         print: You entered dimensions of 'length' feet by 'width' feet.
         'squareFeetArea' = 'length' * 'width'
         'squareMeterArea' = 'squareFeetArea' * 'conversionFactor'
         print: The area is 'squareFeetArea' square feet, 'squareMeterArea' square meters.
      */
    private static final Scanner input = new Scanner(System.in);
    private static final DecimalFormat df = new DecimalFormat("#.###");

    public static void main(String[] args) {
        Solution07 areaCalculator = new Solution07();
        double conversionFactor = 0.09290304;
        double length = areaCalculator.gatherDimension("length");
        double width = areaCalculator.gatherDimension("width");
        System.out.println("You entered dimensions of " + df.format(length) + " feet by " + df.format(width) + " feet.");
        double squareFt = length * width;
        double squareM = squareFt * conversionFactor;
        areaCalculator.printMeasurements(squareFt, squareM);

    }

    public double gatherDimension(String dimension) {
        System.out.print("What is the " + dimension + " of the room in feet? ");
        String currentString = input.nextLine();
        return Double.parseDouble(currentString);
    }

    public void printMeasurements(double squareFt, double squareM) {
        String printArea = "The area is\n" + df.format(squareFt) + " square feet\n" + df.format(squareM) + " square meters";
        System.out.print(printArea);
    }
}
