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
        if (password.matches("(?i).*" + "qwerty" + ".*")
                || password.matches("(?i).*" + "password" + ".*")
                || password.matches("(?i).*" + "admin" + ".*")
                || password.matches("(?i).*" + "user" + ".*")
                || password.matches(".*" + "12345" + ".*")) {
            throw new IllegalArgumentException("Password shouldn't contain substrings: qwerty, 12345, password, admin, user");
            }
            return password;
    }
}
