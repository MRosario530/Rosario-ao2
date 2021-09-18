/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Miguel Rosario
 */
package solution;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;

public class Solution14 {
    /*
        print: What is the order amount?
            'order' = read string from user and convert to BigDecimal.
            round up to the next penny
        print: What is the state?
            'state' = read string from user.
        if 'state'.equals("WI")
            'tax' = .055 * order
            print: The tax is 'Tax'.
            print: The subtotal is 'order'
        print: The total is ('order' + 'tax').
    */
    private static final Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        Solution14 taxCalculator = new Solution14();
        BigDecimal order = taxCalculator.inputOrder();
        String state = taxCalculator.inputState();
        taxCalculator.output(order, state);
    }

    public BigDecimal inputOrder() {
        System.out.print("What is the order amount? ");
        String orderString = input.nextLine();
        BigDecimal order = new BigDecimal(orderString);
        return order.setScale(2, RoundingMode.HALF_UP);
    }

    public String inputState() {
        System.out.print("What is the state? ");
        return input.nextLine();
    }

    private BigDecimal findTax(BigDecimal dollars) {
        BigDecimal total = dollars.multiply(BigDecimal.valueOf(0.055));
        return total.setScale(2, RoundingMode.HALF_UP);
    }

    public void output(BigDecimal order, String state) {
        DecimalFormat money = new DecimalFormat("0.00");
        String outputStatement = "";
        BigDecimal total = order;
        // Only finds the tax and adds the subtotal and tax statements to the print statement if the state is WI.
        if(state.equals("WI")) {
            BigDecimal tax = findTax(order);
            outputStatement += "The subtotal is $" + money.format(order) + ".\n";
            outputStatement += "The tax is $" + money.format(tax) + ".\n";
            total = total.add(tax);
        }
        outputStatement += "The total is $" + money.format(total) + ".";
        System.out.println(outputStatement);
    }
}
