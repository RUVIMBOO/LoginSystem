package com.mycompany.loginsystems; // Declares the package name

import java.util.Random; // Imports Random class for generating random numbers
import java.io.FileWriter; // Imports FileWriter class for writing to files
import java.io.IOException; // Imports IOException class for handling file errors

public class Message { // Message class declaration

    String messageID; // Stores generated message ID
    String recipient; // Stores recipient number
    String message; // Stores message text
    String messageHash; // Stores generated message hash

    String[] sentMessages = new String[100]; // Array to store sent messages

    int messageCount = 0; // Counter for messages stored in array

    static int totalMessages = 0; // Static counter for total messages sent

    // ================= GENERATE MESSAGE ID =================

    public void generateMessageID() { // Method to generate message ID

        Random random = new Random(); // Creates Random object

        int number = // Generates random 9-digit number
                100000000 + random.nextInt(900000000);

        messageID = String.valueOf(number); // Converts number to String and stores it

        System.out.println( // Displays generated message ID
                "Message ID generated: "
                + messageID);
    }

    // ================= CHECK RECIPIENT =================

    public String checkRecipientCell(String recipient) { // Method to validate recipient number

        if (recipient.startsWith("+27") // Checks if number starts with +27
                && recipient.length() <= 12) { // Checks if number length is valid

            return "Cell phone number successfully captured."; // Returns success message

        } else {

            return "Cell phone number is incorrectly formatted."; // Returns error message
        }
    }

    // ================= CREATE HASH =================

    public String createMessageHash() { // Method to create message hash

        String firstTwo = // Stores first two characters of message ID
                messageID.substring(0, 2);

        String[] words = message.split(" "); // Splits message into words

        String firstWord = words[0]; // Stores first word of message

        String lastWord = words[words.length - 1]; // Stores last word of message

        messageHash = // Creates message hash
                firstTwo
                + ":"
                + totalMessages
                + ":"
                + firstWord.toUpperCase()
                + lastWord.toUpperCase();

        return messageHash; // Returns generated message hash
    }

    // ================= SEND MESSAGE =================

    public String SentMessage(int choice) { // Method to process message option

        if (choice == 1) { // Checks if user selected send message

            totalMessages++; // Increases total messages counter

            return "Message successfully sent."; // Returns success message

        } else if (choice == 2) { // Checks if user selected discard message

            return "Message discarded."; // Returns discard message

        } else if (choice == 3) { // Checks if user selected store message

            storeMessage(); // Calls method to store message

            return "Message successfully stored."; // Returns stored message

        } else {

            return "Invalid option."; // Returns invalid option message
        }
    }

    // ================= PRINT MESSAGE =================

    public String printMessages() { // Method to display message details

        return "\nMessage ID: " // Returns formatted message information
                + messageID
                + "\nMessage Hash: "
                + messageHash
                + "\nRecipient: "
                + recipient
                + "\nMessage: "
                + message;
    }

    // ================= STORE MESSAGE =================

    public void storeMessage() { // Method to store message in file

        try { // Starts try block for file handling

            FileWriter file = // Creates FileWriter object
                    new FileWriter("messages.json", true);

            file.write( // Writes message data into file
                    "{\n"
                    + "\"MessageID\":\"" + messageID + "\",\n"
                    + "\"Recipient\":\"" + recipient + "\",\n"
                    + "\"Message\":\"" + message + "\"\n"
                    + "}\n"
            );

            file.close(); // Closes file after writing

        } catch (IOException e) { // Catches file handling errors

            System.out.println( // Displays error message
                    "Error saving message.");
        }
    }

    // ================= TOTAL MESSAGES =================

    public int returnTotalMessages() { // Method to return total messages count

        return totalMessages; // Returns total messages value
    }

    // ================= ADD TO ARRAY =================

    public void addMessageToArray() { // Method to add message to array

        sentMessages[messageCount] = // Stores printed message in array
                printMessages();

        messageCount++; // Increases message counter
    }
}