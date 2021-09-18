/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Miguel Rosario
 */
package solution;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.math.BigDecimal;
import java.util.*;

public class Solution11 {
    /*
        print: How many euros are you exchanging?
            'euros' = read string from user and convert to integer.
        print: What is the exchange rate?
            'exchangeRate' = read string from user and convert to double.
        (BigDecimal)'dollars' = 'currentEuros' * 'exchangeRate'
            round up to the nearest hundredth
        print: 'euros' euros at an exchange rate of 'exchangeRate' is 'dollars' U.S. dollars.
     */
    private static final Scanner input = new Scanner(System.in);
    public static void main(String[] args){
        Solution11 conversionCalculator = new Solution11();
        BigDecimal[] conversionValues = conversionCalculator.gatherMoneyInfo();
        BigDecimal convertedCurrency = conversionCalculator.eurosToDollars(conversionValues);
        conversionCalculator.printConversion(conversionValues, convertedCurrency);
    }

    public BigDecimal[] gatherMoneyInfo(){
        // Stores first input for euros in values[0] and second input for exchange rate in values[1]
        BigDecimal[] values = new BigDecimal[2];
        String tempString;
        System.out.print("How many euros are you exchanging? ");
        tempString = input.nextLine();
        values[0] = new BigDecimal(tempString);
        System.out.print("What is the exchange rate? ");
        tempString = input.nextLine();
        values[1] = new BigDecimal(tempString);
        return values;
    }

    public BigDecimal eurosToDollars(BigDecimal[] conversionValues){
        BigDecimal dollars = conversionValues[0].multiply(conversionValues[1]);
        return dollars.setScale(2, RoundingMode.UP);
    }

    public void printConversion(BigDecimal[] conversionValues, BigDecimal convertedCurrency) {
        DecimalFormat df = new DecimalFormat("#.00");
        String conversion = conversionValues[0] + " euros at an exchange rate of " + conversionValues[1]
                + " is\n" + df.format(convertedCurrency) + " U.S. dollars.";
        System.out.println(conversion);
    }
}