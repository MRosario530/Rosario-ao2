/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Miguel Rosario
 */
package solution;

import java.text.DecimalFormat;
import java.util.*;

public class Solution13 {
    /*
        print: What is the principal amount?
            'principal' = read string from user and convert to double.
        print: What is the rate of interest?
            'rateOfInterest' = read string from user and convert to double.
        print: What is the number of years?
            'numOfYears' = read string from user and convert to double.
        print: What is the number of times the interest is compounded per year?
            'numOfTimesCompounded' = read string from user and convert to int.
        'compoundInterest' = 'principal'  *
            (1 + (('rateOfInterest' / 100) / 'numOfTimesCompounded'))^(numOfTimesCompounded * numOfYears)
            round up to the next penny
        print: 'principal' invested at 'rateOfInterest' for 'numOfYears' compounded 'numOfTimesCompounded' times per
            year is 'compoundInterest'.
    */
    private static final Scanner input = new Scanner(System.in);
    public static void main(String[] args){
        Solution13 compoundIntCalc = new Solution13();
        double[] interestArray = compoundIntCalc.interestValues();
        double investment = compoundIntCalc.calcCompoundInterest(interestArray);
        compoundIntCalc.printCompoundInterest(interestArray, investment);
    }

    private double gatherValue(String searchTopic) {
        System.out.print("What is the " + searchTopic + "? ");
        String stringValue = input.nextLine();
        return Double.parseDouble(stringValue);
    }

    public double[] interestValues() {
        // Stores the 4 values of principal, rate of interest, number of years and number of times interest is
        // compounded into a double array at positions 0, 1, 2, and 3 respectively.
        double[] interestArray = new double[4];
        interestArray[0] = gatherValue("principal amount");
        interestArray[1] = gatherValue("rate(%)");
        interestArray[2] = gatherValue("number of years");
        interestArray[3] = (int)gatherValue("number of times the interest is compounded per year");
        return interestArray;
    }

    public double calcCompoundInterest(double[] interestValues) {
        double compoundInterest = (1+((interestValues[1]/100)/interestValues[3]));
        compoundInterest = Math.pow(compoundInterest, (interestValues[3]*interestValues[2]));
        compoundInterest = compoundInterest*interestValues[0];
        return roundToPenny(compoundInterest);
    }

    public double roundToPenny(double dollars){
        return (Math.ceil(dollars*100))/100.0;
    }

    public void printCompoundInterest(double[] interestValues, double investment) {
        DecimalFormat df = new DecimalFormat("#.##");
        DecimalFormat money = new DecimalFormat("#.00");
        String compoundInterestOutput = "$" + money.format(interestValues[0]) + " invested at " +
                df.format(interestValues[1]) + "% for " + df.format(interestValues[2]) + " years compounded " +
                df.format(interestValues[3]) + " times per year is $" + money.format(investment) + ".";
        System.out.println(compoundInterestOutput);
    }
}
