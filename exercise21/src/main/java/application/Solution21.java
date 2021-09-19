/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Miguel Rosario
 */
package application;

import java.util.*;

public class Solution21 {
    /*
        print: Please enter the number of the month.
            'userMonth' = read string from user and convert to int.
                Use try/catch to ensure user inputs an integer, otherwise prompt the user again for the month.
        'output' = "The name of the month is "
        switch 'userMonth'
            case 1
                'output' += January
            case 2
                'output' += February
            case 3
                'output' += March
            case 4
                'output' += April
            case 5
                'output' += May
            case 6
                'output' += June
            case 7
                'output' += July
            case 8
                'output' += August
            case 9
                'output' += September
            case 10
                'output' += October
            case 11
                'output' += November
            case 12
                'output' += December
            default
                'output' = "Invalid month"
        print 'output'
    */
    private static final Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        Solution21 monthFinder = new Solution21();
        int userInputMonthNum = monthFinder.getInt("Please enter the number of the month: ");
        monthFinder.printMonth(userInputMonthNum);
    }

    public int getInt(String ques) { // Method to get and error check an integer, prints a user given question.
        int result = 0;
        boolean invalidInt;
        do {
            invalidInt = false;
            try {
                System.out.print(ques);
                result = input.nextInt();
            }catch(InputMismatchException e) {
                invalidInt = true;
                input.nextLine();  //Clears out keyboard buffer.
            }
        }while(invalidInt);
        return result;
    }

    public void printMonth(int userInputMonthNum) {
        String monthName = "The name of the month is ";
        switch (userInputMonthNum) {
            case 1:  monthName += "January.";
                break;
            case 2:  monthName += "February.";
                break;
            case 3:  monthName += "March.";
                break;
            case 4:  monthName += "April.";
                break;
            case 5:  monthName += "May.";
                break;
            case 6:  monthName += "June.";
                break;
            case 7:  monthName += "July.";
                break;
            case 8:  monthName += "August.";
                break;
            case 9:  monthName += "September.";
                break;
            case 10: monthName += "October.";
                break;
            case 11: monthName += "November.";
                break;
            case 12: monthName += "December.";
                break;
            default: monthName = "The month you entered was invalid. ";
                break;
        }
        System.out.println(monthName);
    }
}
