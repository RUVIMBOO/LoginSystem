package com.mycompany.loginsystems; // Declares the package name

public class Login { // Login class declaration

    // Variables
    String username; // Stores username
    String password; // Stores password
    String cell; // Stores cell phone number

    // Username method
    public boolean checkUserName(String username) { // Method to validate username

        if (username.contains("_") && username.length() <= 5) { // Checks if username contains "_" and is 5 characters or less
            return true; // Returns true if valid
        } else {
            return false; // Returns false if invalid
        }
    }

    // Password method
    public boolean checkPasswordComplexity(String password) { // Method to validate password

        boolean hasCapital = false; // Tracks if password has uppercase letter
        boolean hasNumber = false; // Tracks if password has number
        boolean hasSpecial = false; // Tracks if password has special character

        for (int i = 0; i < password.length(); i++) { // Loops through each password character

            char c = password.charAt(i); // Stores current character

            if (Character.isUpperCase(c)) { // Checks if character is uppercase
                hasCapital = true; // Sets hasCapital to true
            }

            if (Character.isDigit(c)) { // Checks if character is a number
                hasNumber = true; // Sets hasNumber to true
            }

            if (!Character.isLetterOrDigit(c)) { // Checks if character is special
                hasSpecial = true; // Sets hasSpecial to true
            }
        }

        if (password.length() >= 8 // Checks if password has at least 8 characters
                && hasCapital // Checks if password contains uppercase letter
                && hasNumber // Checks if password contains number
                && hasSpecial) { // Checks if password contains special character

            return true; // Returns true if all conditions are met

        } else {

            return false; // Returns false if conditions are not met
        }
    }

    // Cell phone method
    public boolean checkCellPhoneNumber(String cell) { // Method to validate cell number

        if (cell.startsWith("+27") && cell.length() <= 12) { // Checks if number starts with +27 and length is valid
            return true; // Returns true if valid
        } else {
            return false; // Returns false if invalid
        }
    }

    // Register user
    public String registerUser(String username, // Method to register user
                               String password, // Password parameter
                               String cell) { // Cell number parameter

        this.username = username; // Saves username to class variable
        this.password = password; // Saves password to class variable
        this.cell = cell; // Saves cell number to class variable

        if (!checkUserName(username)) { // Checks if username is invalid

            return "Username is not correctly formatted."; // Returns username error message

        }

        if (!checkPasswordComplexity(password)) { // Checks if password is invalid

            return "Password is not correctly formatted."; // Returns password error message

        }

        if (!checkCellPhoneNumber(cell)) { // Checks if cell number is invalid

            return "Cell phone number incorrectly formatted."; // Returns cell number error message

        }

        return "User registered successfully."; // Returns success message
    }

    // Login method
    public boolean loginUser(String loginUsername, // Method to verify login username
                             String loginPassword) { // Method to verify login password

        if (loginUsername.equals(username) // Checks if entered username matches stored username
                && loginPassword.equals(password)) { // Checks if entered password matches stored password

            return true; // Returns true if login details are correct

        } else {

            return false; // Returns false if login details are incorrect
        }
    }

    // Return login status
    public String returnLoginStatus(boolean loginStatus) { // Method to return login message

        if (loginStatus) { // Checks if login was successful

            return "Welcome user! It is great to see you again."; // Success login message

        } else {

            return "Username or password incorrect."; // Failed login message
        }
    }
}