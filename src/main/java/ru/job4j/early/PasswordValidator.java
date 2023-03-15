package ru.job4j.early;

public class PasswordValidator {
    public static String validate(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password can't be null");
        }
        if (password.length() < 8 || password.length() > 32) {
            throw new IllegalArgumentException("Password should be length [8, 32]");
        }
        boolean hasUpperCase = false, hasLowerCase = false, hasFigure = false, hasSpecial = false;
        for (int i = 0; i < password.length(); i++) {
            if (Character.isUpperCase(password.charAt(i))) {
                hasUpperCase = true;
            }
            if (Character.isLowerCase(password.charAt(i))) {
                hasLowerCase = true;
            }
            if (Character.isDigit(password.charAt(i))) {
                hasFigure = true;
            }
            if (!Character.isLetterOrDigit(password.charAt(i))) {
                hasSpecial = true;
            }
        }
        if (!hasUpperCase) {
            throw new IllegalArgumentException("Password should contain at least one uppercase letter");
        }
        if (!hasLowerCase) {
            throw new IllegalArgumentException("Password should contain at least one lowercase letter");
        }
        if (!hasFigure) {
            throw new IllegalArgumentException("Password should contain at least one figure");
        }
        if (!hasSpecial) {
            throw new IllegalArgumentException("Password should contain at least one special symbol");
        }
        String[] invalid = new String[]{"qwerty", "12345", "password", "admin", "user"};
        for (int i = 0; i < invalid.length; i++) {
            if (password.toLowerCase().contains(invalid[i].toLowerCase())) {
                throw new IllegalArgumentException("Password shouldn't contain substrings: qwerty, 12345, password, admin, user");
            }
        }
        return password;
    }
}