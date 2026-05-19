package com.mycompany.loginsystems;

import java.util.Scanner;

public class LoginSystems {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Login login = new Login();

        Message msg = new Message();

        // ================= REGISTER =================

        System.out.println("=== REGISTER ===");

        System.out.print("Enter username: ");
        String username = input.nextLine();

        System.out.print("Enter password: ");
        String password = input.nextLine();

        System.out.print("Enter cell number: ");
        String cell = input.nextLine();

        String registerMessage =
                login.registerUser(username,
                        password,
                        cell);

        System.out.println(registerMessage);

        // ================= LOGIN =================

        System.out.println("\n=== LOGIN ===");

        System.out.print("Enter username: ");
        String loginUser = input.nextLine();

        System.out.print("Enter password: ");
        String loginPass = input.nextLine();

        boolean loginStatus =
                login.loginUser(loginUser,
                        loginPass);

        System.out.println(
                login.returnLoginStatus(loginStatus));

        // ================= PART 2 =================

        if (loginStatus) {

            System.out.println("\nWelcome to QuickChat");

            int option;

            do {

                System.out.println("\n===== MENU =====");
                System.out.println("1) Send Messages");
                System.out.println("2) Show recently sent messages");
                System.out.println("3) Quit");

                System.out.print("Choose option: ");

                option = input.nextInt();
                input.nextLine();

                // ================= SEND MESSAGE =================

                if (option == 1) {

                    msg.generateMessageID();

                    // Recipient number
                    System.out.print("Enter recipient number: ");
                    msg.recipient = input.nextLine();

                    System.out.println(
                            msg.checkRecipientCell(
                                    msg.recipient));

                    // Message text
                    System.out.print("Enter message: ");
                    msg.message = input.nextLine();

                    // Message length check
                    if (msg.message.length() <= 250) {

                        System.out.println(
                                "Message ready to send.");

                        // Create message hash
                        msg.createMessageHash();

                        // Message options
                        System.out.println("\n1) Send Message");
                        System.out.println("2) Discard Message");
                        System.out.println("3) Store Message");

                        System.out.print("Choose: ");

                        int sendChoice = input.nextInt();
                        input.nextLine();

                        // Show result
                        System.out.println(
                                msg.SentMessage(sendChoice));

                        if (sendChoice == 1) {

                        msg.addMessageToArray();
                         }
                        
                        // Print message details
                        System.out.println(
                                msg.printMessages());

                    } else {

                        int extra =
                                msg.message.length() - 250;

                        System.out.println(
                                "Message exceeds 250 characters by "
                                + extra);
                    }

                }

                // ================= SHOW MESSAGES =================

                else if (option == 2) {

                    System.out.println(
                            "Coming Soon.");
                }

            } while (option != 3);
         System.out.println(
        "Total messages sent: "
        + msg.returnTotalMessages());
         
            System.out.println("Goodbye.");
        }

        input.close();
    }
}