package com.mycompany.loginsystems;

import java.util.Random;
import java.io.FileWriter;
import java.io.IOException;

public class Message {

    String messageID;
    String recipient;
    String message;
    String messageHash;

    String[] sentMessages = new String[100];

    int messageCount = 0;

    static int totalMessages = 0;

    // ================= GENERATE MESSAGE ID =================

    public void generateMessageID() {

        Random random = new Random();

        int number =
                100000000 + random.nextInt(900000000);

        messageID = String.valueOf(number);

        System.out.println(
                "Message ID generated: "
                + messageID);
    }

    // ================= CHECK RECIPIENT =================

    public String checkRecipientCell(String recipient) {

        if (recipient.startsWith("+27")
                && recipient.length() <= 12) {

            return "Cell phone number successfully captured.";

        } else {

            return "Cell phone number is incorrectly formatted.";
        }
    }

    // ================= CREATE HASH =================

    public String createMessageHash() {

        String firstTwo =
                messageID.substring(0, 2);

        String[] words = message.split(" ");

        String firstWord = words[0];

        String lastWord = words[words.length - 1];

        messageHash =
                firstTwo
                + ":"
                + totalMessages
                + ":"
                + firstWord.toUpperCase()
                + lastWord.toUpperCase();

        return messageHash;
    }

    // ================= SEND MESSAGE =================

    public String SentMessage(int choice) {

        if (choice == 1) {

            totalMessages++;

            return "Message successfully sent.";

        } else if (choice == 2) {

            return "Message discarded.";

        } else if (choice == 3) {

            storeMessage();

            return "Message successfully stored.";

        } else {

            return "Invalid option.";
        }
    }

    // ================= PRINT MESSAGE =================

    public String printMessages() {

        return "\nMessage ID: "
                + messageID
                + "\nMessage Hash: "
                + messageHash
                + "\nRecipient: "
                + recipient
                + "\nMessage: "
                + message;
    }

    // ================= STORE MESSAGE =================

    public void storeMessage() {

        try {

            FileWriter file =
                    new FileWriter("messages.json", true);

            file.write(
                    "{\n"
                    + "\"MessageID\":\"" + messageID + "\",\n"
                    + "\"Recipient\":\"" + recipient + "\",\n"
                    + "\"Message\":\"" + message + "\"\n"
                    + "}\n"
            );

            file.close();

        } catch (IOException e) {

            System.out.println(
                    "Error saving message.");
        }
    }

    // ================= TOTAL MESSAGES =================

    public int returnTotalMessages() {

        return totalMessages;
    }

    // ================= ADD TO ARRAY =================

    public void addMessageToArray() {

        sentMessages[messageCount] =
                printMessages();

        messageCount++;
    }
}