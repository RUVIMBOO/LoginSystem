package com.mycompany.loginsystems;

public class Login {

    // Variables
    String username;
    String password;
    String cell;

    // Username method
    public boolean checkUserName(String username) {

        if (username.contains("_") && username.length() <= 5) {
            return true;
        } else {
            return false;
        }
    }

    // Password method
    public boolean checkPasswordComplexity(String password) {

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

        if (password.length() >= 8
                && hasCapital
                && hasNumber
                && hasSpecial) {

            return true;

        } else {

            return false;
        }
    }

    // Cell phone method
    public boolean checkCellPhoneNumber(String cell) {

        if (cell.startsWith("+27") && cell.length() <= 12) {
            return true;
        } else {
            return false;
        }
    }

    // Register user
    public String registerUser(String username,
                               String password,
                               String cell) {

        this.username = username;
        this.password = password;
        this.cell = cell;

        if (!checkUserName(username)) {

            return "Username is not correctly formatted.";

        }

        if (!checkPasswordComplexity(password)) {

            return "Password is not correctly formatted.";

        }

        if (!checkCellPhoneNumber(cell)) {

            return "Cell phone number incorrectly formatted.";

        }

        return "User registered successfully.";
    }

    // Login method
    public boolean loginUser(String loginUsername,
                             String loginPassword) {

        if (loginUsername.equals(username)
                && loginPassword.equals(password)) {

            return true;

        } else {

            return false;
        }
    }

    // Return login status
    public String returnLoginStatus(boolean loginStatus) {

        if (loginStatus) {

            return "Welcome user! It is great to see you again.";

        } else {

            return "Username or password incorrect.";
        }
    }
}
