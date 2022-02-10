package edu.epam.jwd.validator;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberArrayValidator {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final String REGEX_NUMBER = "^[-?\\d+\\s]+$";
    private static final Pattern PATTERN = Pattern.compile(REGEX_NUMBER);

    private NumberArrayValidator() {
    }

    public static boolean isValidDigitLine(String line) {
        if (line == null || line.isEmpty()) {
            LOGGER.log(Level.ERROR, "line is empty");
            return false;
        }
        Matcher matcher = PATTERN.matcher(line);
        return matcher.matches();
    }
}
