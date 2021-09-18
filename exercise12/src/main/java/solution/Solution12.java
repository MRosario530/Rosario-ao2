/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Miguel Rosario
 */
package solution;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.math.BigDecimal;
import java.util.*;

public class Solution12 {
    /*
        print: Enter the principal:
            'principal' = read string from user and convert to BigDecimal.
        print: Enter the rate of interest:
            'rateOfInterest' = read string from user and convert to BigDecimal.
        print: Enter the numberOfYears:
            'numOfYears' = read string from user and convert to BigDecimal.
        'simpleInterest' = 'principal' * (1 + 'rateOfInterest' * 'numOfYears'
            round up to the next penny
        print: After 'numOfYears' at 'rateOfInterest'%, the investment will be worth $'simpleInterest'
    */
    private static final Scanner input = new Scanner(System.in);
    public static void main(String[] args){
        Solution12 simpleIntCalc = new Solution12();
        BigDecimal[] interestArray = simpleIntCalc.interestValues();
        BigDecimal investment = simpleIntCalc.calcSimpleInterest(interestArray);
        simpleIntCalc.printSimpleInterest(interestArray, investment);
    }

    private BigDecimal gatherUserMoneyInput(String searchTopic) {
        System.out.print("Enter the " + searchTopic + ": ");
        String stringValue = input.nextLine();
        return new BigDecimal(stringValue);
    }

    public BigDecimal[] interestValues() {
        // Stores the 3 values of principal, rate of interest, and number of years into a BigDecimal array
        // at positions 0, 1, and 2, respectively.
        BigDecimal[] interestArray = new BigDecimal[3];
        interestArray[0] = gatherUserMoneyInput("principal");
        interestArray[1] = gatherUserMoneyInput("rate(%) of interest");
        interestArray[2] = gatherUserMoneyInput("number of years");
        return interestArray;
    }

    public BigDecimal calcSimpleInterest(BigDecimal[] interestValues) {
        BigDecimal simpleInterest = interestValues[1].divide(BigDecimal.valueOf(100));
        simpleInterest = simpleInterest.multiply(interestValues[2]);
        simpleInterest = simpleInterest.add(BigDecimal.valueOf(1));
        simpleInterest = simpleInterest.multiply(interestValues[0]);
        return simpleInterest.setScale(2, RoundingMode.UP);
    }

    public void printSimpleInterest(BigDecimal[] interestValues, BigDecimal investment) {
        DecimalFormat df = new DecimalFormat("#.##");
        DecimalFormat money = new DecimalFormat("#.00");
        String simpleInterestOutput = "After " + df.format(interestValues[2]) + " years at "
                + df.format(interestValues[1]) + "%, the investment will be worth $" + money.format(investment) + ".";
        System.out.println(simpleInterestOutput);
    }
}