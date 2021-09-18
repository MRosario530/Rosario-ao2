/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Miguel Rosario
 */
package solution;

import java.util.*;

public class Solution08 {
    /*
        print: How many people?
            'peopleCount' = read string from user and convert to integer.
        print: How many pizzas do you have?
            'pizzaCount' = read string from user and convert to integer.
        print: How many slices per pizza?
            'sliceCount' = read string from user and convert to integer.
        totalSlices = (pizzaCount * sliceCount)
        'slicesPerPerson' = totalSlices / peopleCount
        'leftovers' = totalSlices % peopleCount
        print: 'peopleCount' people with 'pizzaCount' pizzas ('totalSlices' slices)
        print: Each person gets 'slicesPerPerson' pieces of pizza.
        print: There are 'leftovers' leftover pieces.
     */
    private static final Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        Solution08 pizzaCalculator = new Solution08();
        int peopleCount = pizzaCalculator.userInputToInt("How many people? ");
        int pizzaCount = pizzaCalculator.userInputToInt("How many pizzas do you have? ");
        int sliceCount = pizzaCalculator.userInputToInt("How many slices per pizza? ");
        int totalSlices = pizzaCount * sliceCount;
        int slicesPerPerson = pizzaCalculator.calculateSlices(peopleCount, totalSlices);
        int leftovers = pizzaCalculator.calculateLeftovers(peopleCount, totalSlices);
        pizzaCalculator.printPizzaInfo(peopleCount, pizzaCount, slicesPerPerson, leftovers, totalSlices);
    }

    public int userInputToInt(String message) {
        System.out.print(message);
        String currentString = input.nextLine();
        return Integer.parseInt(currentString);
    }

    public int calculateSlices(int peopleCount, int totalSlices) {
        return totalSlices / peopleCount;
    }

    public int calculateLeftovers(int peopleCount, int totalSlices) {
        return totalSlices % peopleCount;
    }

    public void printPizzaInfo(int peopleCount, int pizzaCount, int slicesPerPerson, int leftovers, int totalSlices) {
        String pizzaInfo = peopleCount + " people with " + pizzaCount + " pizzas (" + totalSlices + " slices)\n";
        pizzaInfo += "Each person gets " + slicesPerPerson + " pieces of pizza.\n";
        pizzaInfo += "There are " + leftovers + " leftover pieces.";
        System.out.println(pizzaInfo);
    }
}