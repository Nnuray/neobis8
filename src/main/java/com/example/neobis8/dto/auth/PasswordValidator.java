package com.example.neobis8.dto.auth;

import java.util.regex.Pattern;

public class PasswordValidator {

    private static final int MIN_LENGTH = 8;
    private static final int MAX_LENGTH = 15;

    public static boolean isValidPassword(String password) {
        if (password.length() < MIN_LENGTH || password.length() > MAX_LENGTH) {
            return false;
        }

        if (!containsLowercaseLetter(password) || !containsUppercaseLetter(password)) {
            return false;
        }

        if (!containsDigit(password)) {
            return false;
        }

        if (!containsSpecialCharacter(password)) {
            return false;
        }

        return true;
    }

    private static boolean containsLowercaseLetter(String password) {
        return Pattern.compile("[a-z]").matcher(password).find();
    }

    private static boolean containsUppercaseLetter(String password) {
        return Pattern.compile("[A-Z]").matcher(password).find();
    }

    private static boolean containsDigit(String password) {
        return Pattern.compile("[0-9]").matcher(password).find();
    }

    private static boolean containsSpecialCharacter(String password) {
        return Pattern.compile("[!@#$%^&*()_+\\[\\]{};':\",.<>?]").matcher(password).find();
    }
}