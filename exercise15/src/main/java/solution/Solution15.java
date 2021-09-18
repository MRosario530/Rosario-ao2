/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Miguel Rosario
 */
package solution;

import java.util.*;

public class Solution15 {
    private static final Scanner input = new Scanner(System.in);
    /*
        'correctPassword' = abc$123
        print: What is your username?
            'username' = read string from user.
        print: What is the password?
            'userPassword' = read string from user.
        if 'userPassword'.equals 'correctPassword'
            print: Welcome!
        else
            print: I don't know you.
    */
    public static void main(String[] args){
        Solution15 passwordVerifier = new Solution15();
        String correctPassword = "abc$123";
        String[] userInputtedInfo = passwordVerifier.inputNameAndPassword();
        passwordVerifier.confirmPassword(userInputtedInfo[1], correctPassword);
    }

    public String[] inputNameAndPassword() {
        String[] nameAndPassword = new String[2];
        System.out.print("What is your username? ");
        nameAndPassword[0] = input.nextLine();
        System.out.print("What is the password? ");
        nameAndPassword[1] = input.nextLine();
        return nameAndPassword;
    }

    public void confirmPassword(String userPassword, String actualPassword) {
        if(userPassword.equals(actualPassword)) {
            System.out.println("Welcome!");
        }else {
            System.out.println("I don't know you.");
        }
    }
}
