package edu.epam.jwd.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberArrayValidator {
    private static final Logger logger = LogManager.getLogger();
    private static final String REGEX_NUMBER = "^[-?[\\d]+[\\s]+ ]+$";

    private NumberArrayValidator() {
    }

    public static boolean isValidateDigitLine(String line) {
        if (line == null || line.length() == 0) {
            logger.debug("isValidation, input string is empty");
            return false;
        }
        Pattern pattern = Pattern.compile(REGEX_NUMBER);
        Matcher matcher = pattern.matcher(line);
        return matcher.matches();
    }
}
