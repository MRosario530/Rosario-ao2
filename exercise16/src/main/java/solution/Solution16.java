/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Miguel Rosario
 */
package solution;

import java.util.*;

public class Solution16 {
    /*
        print: What is your age?
            'userAge' = read string from user and convert to int.
         'canDrive' = if 'userAge' >= 16
            ? 'canDrive' = You are old enough to legally drive
            : 'canDrive' = You are not old enough to legally drive.
            print 'canDrive'.
    */
    private static final Scanner input = new Scanner (System.in);
    public static void main(String[] args) {
        Solution16 drivingCalculator = new Solution16();
        int userAge = drivingCalculator.inputAge();
        drivingCalculator.determineCanDrive(userAge);
    }

    public int inputAge() {
        System.out.print("What is your age? ");
        String userAge = input.nextLine();
        return Integer.parseInt(userAge);
    }

    public void determineCanDrive(int age) {
        String canDrive = age >= 16
                ? "You are old enough to legally drive."
                : "You are not old enough to legally drive.";
        System.out.println(canDrive);
    }
}
