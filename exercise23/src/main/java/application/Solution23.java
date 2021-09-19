/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Miguel Rosario
 */
package application;

import java.util.*;

public class Solution23 {
    /*  print: Is the car silent when you turn the key?
            'userResponse' = read string from user and convert to char.
                Use try/catch and conditional to ensure that response is y/n otherwise prompt again.
                    ^this goes for all future responses
        if 'userResponse' == Y
            print: Are the battery terminals corroded?
            'userResponse' = read string from user and convert to char.
            if 'userResponse' == Y
                print: Clean terminals and try starting again.
            else
                print: Replace cables and try again.
        else
            print: Does the car make a slicking noise?
            'userResponse' = read string from user and convert to char.
            if 'userResponse' == Y
                print: Replace the battery.
            else
                 print: Does the car crank up but fail to start?
                'userResponse' = read string from user and convert to char.
                if 'userResponse' == Y
                    print: Check spark plug connections.
                else
                    print: Does the engine start and then die?
                    'userResponse' = read string from user and convert to char.
                    if 'userResponse' == Y
                        print: Does your car have fuel injection?
                        'userResponse' = read string from user and convert to char.
                        if 'userResponse' == Y
                            print: Get it in for service.
                        else
                            print: Check to ensure the choke is opening and closing.
                    else
                        print: This should not be possible.
     */
    private static final Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        Solution23 carTroubleshooter = new Solution23();
        String userIssue = carTroubleshooter.determineCarTrouble();
        System.out.println(userIssue);
    }

    private char getChar(String prompt) { // Method for retrieving a yes or no char response.
        char letter;
        String userInput;
        do {
            System.out.print(prompt);
            userInput = input.next();
            userInput = userInput.toUpperCase();
            letter = userInput.charAt(0);
        } while(letter != 'Y' && letter != 'N');
        return letter;
    }

    public String determineCarTrouble(){
        char userResponse = getChar("Is the car silent when you turn the key? ");
        if(userResponse == 'Y'){
            return determineSilentCarProblem();
        } else {
            return determineLoudCarProblem();
        }
    }

    private String determineSilentCarProblem(){
        char userResponse = getChar("Are the battery terminals corroded? ");
        if(userResponse == 'Y'){
            return "Clean terminals and try starting again.";
        } else {
            return "Replace cables and try again.";
        }
    }

    private String determineLoudCarProblem(){
        char userResponse = getChar("Does the car make a slicking noise? ");
        if(userResponse == 'Y'){
            return "Replace the battery.";
        } else {
            userResponse = getChar("Does the car crank up but fail to start? ");
            if(userResponse == 'Y'){
                return "Check spark plug connections.";
            } else {
                userResponse = getChar("Does the engine start and then die? ");
                if(userResponse == 'Y'){
                    userResponse = getChar("Does your car have fuel injection? ");
                    if(userResponse == 'Y'){
                        return "Get it in for service.";
                    } else {
                        return "Check to ensure the choke is opening and closing.";
                    }
                } else{
                    return "This should not be possible.";
                }
            }
        }
    }
}

