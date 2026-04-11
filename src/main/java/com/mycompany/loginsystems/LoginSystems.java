/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

/*
 * This program is a simple login system.
 * It allows a user to:
 * 1. Register (create username, password, and phone number)
 * 2. Login using the same details
 */
package com.mycompany.loginsystems;

 // Create Scanner object to read input from the user
import java.util.Scanner;

public class LoginSystems {

    public static void main(String[] args) {
     Scanner input = new Scanner(System.in);

        // ===== REGISTER NOW =====
        System.out.println("=== REGISTER NOW ===");

        // Ask user to enter a username
        System.out.print("Enter username: ");
        String username = input.nextLine();

        // Username validation:
        // Must contain "_" and be 5 characters or less
        if (username.contains("_") && username.length() <= 5) {
            System.out.println("Username successfully captured.");
             // If username is incorrect, show error and stop program
        } else {
            System.out.println("Username is not correctly formatted; please ensure it contains an underscore and is no more than 5 characters.");
            return; // stops program
        }
        // Ask user to enter a password
        System.out.print("Enter password: ");
        String password = input.nextLine();

        // Password check
        // These variables check password rules
        boolean hasCapital = false;// checks for uppercase letter
        boolean hasNumber = false;// checks for numbers
        boolean hasSpecial = false;// checks for special characters

         // Loop through each character in the password
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);// get each character

            // Check if character is uppercase
            if (Character.isUpperCase(c)) {
                hasCapital = true;
            }
            // Check if character is a number
            if (Character.isDigit(c)) {
                hasNumber = true;
            }
            // Check if character is a special character
            if (!Character.isLetterOrDigit(c)) {
                hasSpecial = true;
            }
        }

         // Password must:
        // - Be at least 8 characters
        // - Have uppercase letter, number, and special character
        if (password.length() >= 8 && hasCapital && hasNumber && hasSpecial) {
            System.out.println("Password successfully captured.");
        } else {
            // If password is incorrect, show error and stop program
            System.out.println("Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.");
            return;
        }

        // Ask user to enter phone number
        System.out.print("Enter cell number: ");
        String cell = input.nextLine();

        // Phone number validation:
        // Must start with +27 and be no more than 12 characters
        if (cell.startsWith("+27") && cell.length() <= 12) {
            System.out.println("Cell phone number successfully added.");
        } else {
            // If incorrect, show error and stop program
            System.out.println("Cell phone number incorrectly formatted or does not contain international code.");
            return;
        }

        // ===== LOGIN =====
        System.out.println("\n=== LOGIN ===");

        // Ask user to enter username again
        System.out.print("Enter username: ");
        String loginUser = input.nextLine();

        // Ask user to enter password again
        System.out.print("Enter password: ");
        String loginPass = input.nextLine();

        // Check if entered login details match registered details
        if (loginUser.equals(username) && loginPass.equals(password)) {
            System.out.println("Welcome user! It is great to see you again.");
        } else {
            // If details do not match
            System.out.println("Username or password incorrect, please try again.");
        }

        // Close scanner to prevent memory leak
        input.close();
    }
}
    
