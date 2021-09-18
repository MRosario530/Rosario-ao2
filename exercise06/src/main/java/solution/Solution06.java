/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Miguel Rosario
 */
package solution;

import java.util.*;
import java.time.LocalDate;

public class Solution06 {
    /*
        'currentYear' = Get the current year from the computer
        print: What is your current age?
            'currentAge' = read string from user and convert to integer.
        print: At what age would you like to retire?
            'retireAge' = read string from user and convert to integer.
        'timeUntilRetire' = 'retireAge' - 'currentAge'
        'retirementYear' = 'currentYear' + 'timeUntilRetire'
        print: You have 'timeUntilRetire' years left until you can retire.
        print: It's 'currentYear' so you can retire in 'retirementYear'.
     */
    private static final Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        Solution06 retirementCalculator = new Solution06();
        LocalDate currentDate = LocalDate.now();
        int currentYear = currentDate.getYear();
        int currentAgeNum = retirementCalculator.userInputToInt("What is your current age? ");
        int retireAgeNum = retirementCalculator.userInputToInt("At what age would you like to retire? ");
        int timeUntilRetire = retireAgeNum - currentAgeNum;
        retirementCalculator.printRetirement(timeUntilRetire, currentYear);
    }

    public int userInputToInt(String message) {
        System.out.print(message);
        String currentString = input.nextLine();
        return Integer.parseInt(currentString);
    }

    public void printRetirement(int timeUntilRetire, int currentYear) {
        int retirementYear = currentYear + timeUntilRetire;
        String output = "You have " + timeUntilRetire + " years left until you can retire.\n";
        output += "It's " + currentYear + ", so you can retire in " + retirementYear + ".";
        System.out.print(output);
    }
}
