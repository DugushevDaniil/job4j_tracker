package ru.job4j.early;

public class PasswordValidator {
    public static String validate(String password) {
        boolean valid = false;
        if (password == null) {
            throw new IllegalArgumentException("Password can't be null");
        }
        if (password.length() < 8 || password.length() > 32) {
            throw new IllegalArgumentException("Password should be length [8, 32]");
        }
        for (int i = 0; i < password.length(); i++) {
            if (Character.isUpperCase(password.charAt(i))) {
                valid = true;
                break;
            }
        }
            if (!valid) {
                throw new IllegalArgumentException("Password should contain at least one uppercase letter");
            }
            valid = false;
        for (int i = 0; i < password.length(); i++) {
            if (Character.isLowerCase(password.charAt(i))) {
                valid = true;
                break;
            }
        }
        if (!valid) {
                throw new IllegalArgumentException("Password should contain at least one lowercase letter");
            }
            valid = false;
        for (int i = 0; i < password.length(); i++) {
            if (Character.isDigit(password.charAt(i))) {
                valid = true;
                break;
            }
        }
        if (!valid) {
            throw new IllegalArgumentException("Password should contain at least one figure");
        }
        valid = false;
        for (int i = 0; i < password.length(); i++) {
            if (!Character.isLetterOrDigit(password.charAt(i))) {
                valid = true;
                break;
            }
        }
        if (!valid) {
            throw new IllegalArgumentException("Password should contain at least one special symbol");
            }
        String invalid1 = "qwerty";
        String invalid2 = "12345";
        String invalid3 = "password";
        String invalid4 = "admin";
        String invalid5 = "user";
        if (password.toLowerCase().contains(invalid1.toLowerCase())
        || password.toLowerCase().contains(invalid2)
        || password.toLowerCase().contains(invalid3.toLowerCase())
        || password.toLowerCase().contains(invalid4.toLowerCase())
        || password.toLowerCase().contains(invalid5.toLowerCase())) {
            throw new IllegalArgumentException("Password shouldn't contain substrings: qwerty, 12345, password, admin, user");
            }
            return password;
    }
}
