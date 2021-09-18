/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Miguel Rosario
 */
package solution;

import java.text.DecimalFormat;
import java.util.*;

public class Solution10 {
    /*
        print: Enter the price of item 1:
            'item1Price' = read string from user and convert to double.
        print: Enter the quantity of item 1:
            'item1Count' = read string from user and convert to integer.
        print: Enter the price of item 2:
            'item2Price' = read string from user and convert to double.
        print: Enter the quantity of item 2:
            'item2Count' = read string from user and convert to integer.
        print: Enter the price of item 3:
            'item3Price' = read string from user and convert to double.
        print: Enter the quantity of item 3:
            'item3Count' = read string from user and convert to integer.
        'subtotal' = ('item1Price' * 'item1Count') + ('item2Price' * 'item2Count') + ('item3Price' * 'item3Count')
            round up to the next penny
        'tax' = 'subtotal' * .055
            round up to the next penny
        'total' = 'subtotal' + 'tax'
            round up to the next penny
        print: Subtotal: $'subtotal', Tax: $'tax', Total:'total'
     */
    private static final Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        Solution10 checkoutCalculator = new Solution10();
        double[][] itemsArray = checkoutCalculator.getItemArray();
        double subtotal = checkoutCalculator.calculateSubtotal(itemsArray);
        double tax = checkoutCalculator.calculateTax(subtotal);
        double total = checkoutCalculator.calculateTotal(subtotal, tax);
        checkoutCalculator.printCosts(subtotal, tax, total);
    }

    public double[][] getItemArray() {
        // A double array is created which each position holding an item's price in [i][0]
        // and its count in [i][1].
        double[][] itemArray = new double[3][2];
        double[] tempItem;
        for (int i = 0; i < 3; i++) {
            tempItem = getItem(i+1);
            itemArray[i][0] = tempItem[0];
            itemArray[i][1] = tempItem[1];
        }
        return itemArray;
    }

    private double[] getItem(int itemNum) {
        double[] tempItem = new double[2];
        String tempString;
        System.out.print("Enter the price of item " + itemNum + ": ");
        tempString = input.nextLine();
        tempItem[0] = Double.parseDouble(tempString);
        System.out.print("Enter the quantity of item " + itemNum + ": ");
        tempString = input.nextLine();
        tempItem[1] = Integer.parseInt(tempString);
        return tempItem;
    }

    public double calculateSubtotal(double[][] itemsArray) {
        double subtotal = 0;
        for(int i = 0; i < 3; i++) {
            subtotal+=(itemsArray[i][0]*itemsArray[i][1]);
        }
        return subtotal;
    }

    public double calculateTax(double subtotal) {
        return subtotal*.055;
    }

    public double calculateTotal(double subtotal, double tax) {
        return subtotal + tax;
    }

    public void printCosts(double subtotal, double tax, double total) {
        DecimalFormat df = new DecimalFormat("#.00");
        String output = "Subtotal: $" + df.format(subtotal);
        output += "\nTax: $" + df.format(tax);
        output += "\nTotal: $" + df.format(total);
        System.out.println(output);
    }
}
