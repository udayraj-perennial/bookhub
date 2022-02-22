package com.perennial.bookhub.util;

import com.perennial.bookhub.exceptions.ConsoleNotFoundException;

import java.io.Console;
import java.util.logging.Logger;

public class PasswordInput {
    private static final String ERROR_MESSAGE = "Couldn't get Console instance";
    private static final String STANDARD_PROMPT = "Password: ";

    public static String read() {
        return read(STANDARD_PROMPT);
    }

    public static String read(String prompt) {
        Logger logger = Logger.getLogger(PasswordInput.class.getName());
        Console console = System.console();
        if (null == console) {
            logger.severe(ERROR_MESSAGE);
            throw new ConsoleNotFoundException(ERROR_MESSAGE);
        }
        console.printf("%s", prompt);
        char[] password = console.readPassword();
        return(new String(password));
    }
}
