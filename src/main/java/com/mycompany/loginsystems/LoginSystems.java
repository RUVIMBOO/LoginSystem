package com.mycompany.loginsystems; // Declares the package name for the program

import java.util.Scanner; // Imports Scanner class for user input

public class LoginSystems { // Main class of the program

    public static void main(String[] args) { // Main method where the program starts

        Scanner input = new Scanner(System.in); // Creates Scanner object for keyboard input

        Login login = new Login(); // Creates Login object

        Message msg = new Message(); // Creates Message object

        // ================= REGISTER =================

        System.out.println("=== REGISTER ==="); // Displays register heading

        System.out.print("Enter username: "); // Prompts user to enter username
        String username = input.nextLine(); // Stores entered username

        System.out.print("Enter password: "); // Prompts user to enter password
        String password = input.nextLine(); // Stores entered password

        System.out.print("Enter cell number: "); // Prompts user to enter cell number
        String cell = input.nextLine(); // Stores entered cell number

        String registerMessage = // Stores registration result message
                login.registerUser(username, // Sends username to registerUser method
                        password, // Sends password to registerUser method
                        cell); // Sends cell number to registerUser method

        System.out.println(registerMessage); // Displays registration result

        // ================= LOGIN =================

        System.out.println("\n=== LOGIN ==="); // Displays login heading

        System.out.print("Enter username: "); // Prompts user to enter login username
        String loginUser = input.nextLine(); // Stores login username

        System.out.print("Enter password: "); // Prompts user to enter login password
        String loginPass = input.nextLine(); // Stores login password

        boolean loginStatus = // Stores login success or failure
                login.loginUser(loginUser, // Sends entered username for login check
                        loginPass); // Sends entered password for login check

        System.out.println( // Displays login status message
                login.returnLoginStatus(loginStatus)); // Returns login message

        // ================= PART 2 =================

        if (loginStatus) { // Checks if login was successful

            System.out.println("\nWelcome to QuickChat"); // Welcomes user to QuickChat

            int option; // Variable for menu option

            do { // Starts loop for menu options

                System.out.println("\n===== MENU ====="); // Displays menu heading
                System.out.println("1) Send Messages"); // Displays send message option
                System.out.println("2) Show recently sent messages"); // Displays show messages option
                System.out.println("3) Quit"); // Displays quit option

                System.out.print("Choose option: "); // Prompts user to choose option

                option = input.nextInt(); // Stores selected option
                input.nextLine(); // Clears Scanner buffer

                // ================= SEND MESSAGE =================

                if (option == 1) { // Checks if user selected send message

                    msg.generateMessageID(); // Generates message ID

                    // Recipient number
                    System.out.print("Enter recipient number: "); // Prompts for recipient number
                    msg.recipient = input.nextLine(); // Stores recipient number

                    System.out.println( // Displays recipient validation result
                            msg.checkRecipientCell( // Checks recipient cell number
                                    msg.recipient));

                    // Message text
                    System.out.print("Enter message: "); // Prompts user to enter message
                    msg.message = input.nextLine(); // Stores message text

                    // Message length check
                    if (msg.message.length() <= 250) { // Checks if message is 250 characters or less

                        System.out.println( // Displays message ready confirmation
                                "Message ready to send.");

                        // Create message hash
                        msg.createMessageHash(); // Creates message hash

                        // Message options
                        System.out.println("\n1) Send Message"); // Displays send option
                        System.out.println("2) Discard Message"); // Displays discard option
                        System.out.println("3) Store Message"); // Displays store option

                        System.out.print("Choose: "); // Prompts user to choose message action

                        int sendChoice = input.nextInt(); // Stores send option choice
                        input.nextLine(); // Clears Scanner buffer

                        // Show result
                        System.out.println( // Displays result of message action
                                msg.SentMessage(sendChoice)); // Calls SentMessage method

                        if (sendChoice == 1) { // Checks if user selected send message

                        msg.addMessageToArray(); // Adds message to array
                         }
                        
                        // Print message details
                        System.out.println( // Displays message details
                                msg.printMessages()); // Calls printMessages method

                    } else { // Executes if message exceeds limit

                        int extra = // Stores number of extra characters
                                msg.message.length() - 250;

                        System.out.println( // Displays error message for long text
                                "Message exceeds 250 characters by "
                                + extra);
                    }

                }

                // ================= SHOW MESSAGES =================

                else if (option == 2) { // Checks if user selected show messages

                    System.out.println( // Displays placeholder message
                            "Coming Soon.");
                }

            } while (option != 3); // Repeats menu until user chooses quit

         System.out.println( // Displays total messages sent
        "Total messages sent: "
        + msg.returnTotalMessages());
         
            System.out.println("Goodbye."); // Displays goodbye message
        }

        input.close(); // Closes Scanner object
    }
}