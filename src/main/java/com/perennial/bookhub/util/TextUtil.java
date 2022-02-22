package com.perennial.bookhub.util;

public class TextUtil {
    public static boolean isAlpha(String term) {
        String alphaAndSpace = "[a-zA-Z]+[\\ ]*";
        return term != null && term.matches(alphaAndSpace);
    }

    public static boolean isAlphaNumeric(String term) {
        String alphaNumericAndSpace = "[a-zA-Z]+[\\ ]*";
        return term != null && term.matches(alphaNumericAndSpace);
    }
}
