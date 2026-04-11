/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.loginsystems;

import java.util.Scanner;

public class LoginSystems {

    public static void main(String[] args) {
     Scanner input = new Scanner(System.in);

        // ===== REGISTER NOW =====
        System.out.println("=== REGISTER NOW ===");

        System.out.print("Enter username: ");
        String username = input.nextLine();

        // Username check
        if (username.contains("_") && username.length() <= 5) {
            System.out.println("Username successfully captured.");
        } else {
            System.out.println("Username is not correctly formatted; please ensure it contains an underscore and is no more than 5 characters.");
            return; // stops program
        }

        System.out.print("Enter password: ");
        String password = input.nextLine();

        // Password check
        boolean hasCapital = false;
        boolean hasNumber = false;
        boolean hasSpecial = false;

        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);

            if (Character.isUpperCase(c)) {
                hasCapital = true;
            }
            if (Character.isDigit(c)) {
                hasNumber = true;
            }
            if (!Character.isLetterOrDigit(c)) {
                hasSpecial = true;
            }
        }

        if (password.length() >= 8 && hasCapital && hasNumber && hasSpecial) {
            System.out.println("Password successfully captured.");
        } else {
            System.out.println("Password is not correctly formatted.");
            return;
        }

        System.out.print("Enter cell number: ");
        String cell = input.nextLine();

        // Cell number check
        if (cell.startsWith("+27") && cell.length() <= 12) {
            System.out.println("Cell phone number successfully added.");
        } else {
            System.out.println("Cell phone number incorrectly formatted.");
            return;
        }

        // ===== LOGIN =====
        System.out.println("\n=== LOGIN ===");

        System.out.print("Enter username: ");
        String loginUser = input.nextLine();

        System.out.print("Enter password: ");
        String loginPass = input.nextLine();

        if (loginUser.equals(username) && loginPass.equals(password)) {
            System.out.println("Welcome! It is great to see you again.");
        } else {
            System.out.println("Username or password incorrect, please try again.");
        }

        input.close();
    }
}
    
