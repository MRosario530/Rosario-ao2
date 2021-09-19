/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Miguel Rosario
 */
package application;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;

public class Solution20 {
    /*
        print: What is the order amount?
            'order' = read string from user and convert to BigDecimal.
        print: What state do you live in?
            'state' = read string from user.
        if 'state'.equals Wisconsin
            print: What county do you live in?
                'county' = read string from user
        'total' = 'order'
        if 'state'.equals Wisconsin
            if 'county'.equals Eau Claire
                'tax' = 'order' * 0.055
                'total' += 'tax'
                    round up 'tax' to the next penny
                print: The tax is 'tax'
            else if 'county'.equals Dunn
                'tax' = 'order' * 0.054
                'total' += 'tax'
                    round up 'tax' to the next penny
                print: The tax is 'tax'
        else if 'state'.equals Illinois
            'tax' = 'order' * 0.08
            'total' += 'tax'
                round up 'tax' to the next penny
            print: The tax is 'tax'
        round up 'total' to the next penny
        print: The total is 'total'.
    */
    private static final Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        String taxState1 = "Wisconsin";
        String taxState2 = "Illinois";
        Solution20 multiStateCalculator = new Solution20();
        BigDecimal order = multiStateCalculator.inputOrder();
        String state = multiStateCalculator.getLocation("What state do you live in? ");
        BigDecimal tax = new BigDecimal("0");
        if(state.equals(taxState1)||state.equals(taxState2)) {
            tax = multiStateCalculator.calculateTax(order, taxState1, state);
        }
        BigDecimal total = multiStateCalculator.calculateTotal(order,tax);
        multiStateCalculator.displayTotals(state, total, tax, taxState1, taxState2);
    }

    public String getLocation (String prompt) {
        System.out.print(prompt);
        return input.nextLine();
    }

    public BigDecimal inputOrder() {
        System.out.print("What is the order amount? ");
        String orderString = input.nextLine();
        return new BigDecimal(orderString);
    }

    public double determineTaxRate(String state, String taxState1) {
        String county;
        double taxRate = 0;
        if(state.equals(taxState1)) {
            county = getLocation("What county do you live in? ");
            taxRate += .05;
        } else {
            taxRate +=.08;
            return taxRate;
        }
        if(county.equals("Eau Claire")) {
            taxRate += .005;
            return taxRate;
        }else if(county.equals("Dunn")) {
            taxRate += .004;
            return taxRate;
        }
        return taxRate;
    }

    public BigDecimal calculateTax(BigDecimal order, String taxState1, String state) {
        double taxRate = determineTaxRate(state, taxState1);
        BigDecimal tax = order.multiply(BigDecimal.valueOf(taxRate));
        return tax.setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal calculateTotal(BigDecimal order, BigDecimal tax) {
        BigDecimal total = order.add(tax);
        return total.setScale(2, RoundingMode.HALF_UP);
    }

    public void displayTotals(String state, BigDecimal total, BigDecimal tax, String taxState1, String taxState2) {
        DecimalFormat money = new DecimalFormat("0.00");
        String totalStatement = "";
        if(state.equals(taxState1)||state.equals(taxState2)) {
            totalStatement += "The tax is $" + money.format(tax) + ".\n";
        }
        totalStatement += "The total is $" + money.format(total) + ".";
        System.out.println(totalStatement);
    }
}
