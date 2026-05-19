package com.mycompany.loginsystems;

import java.util.Scanner;

public class LoginSystems {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Login login = new Login();

        // REGISTER
        System.out.println("=== REGISTER ===");

        System.out.print("Enter username: ");
        String username = input.nextLine();

        System.out.print("Enter password: ");
        String password = input.nextLine();

        System.out.print("Enter cell number: ");
        String cell = input.nextLine();

        String registerMessage =
                login.registerUser(username, password, cell);

        System.out.println(registerMessage);

        // LOGIN
        System.out.println("\n=== LOGIN ===");

        System.out.print("Enter username: ");
        String loginUser = input.nextLine();

        System.out.print("Enter password: ");
        String loginPass = input.nextLine();

        boolean loginStatus =
                login.loginUser(loginUser, loginPass);

        System.out.println(
                login.returnLoginStatus(loginStatus));

        input.close();
    }
}