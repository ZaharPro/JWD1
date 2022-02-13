package edu.epam.jwd.service.impl;

import edu.epam.jwd.entity.IntArray;
import edu.epam.jwd.exception.ReaderArrayException;
import edu.epam.jwd.service.ReaderArrayService;
import edu.epam.jwd.validator.NumberArrayValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ReaderArrayServiceImpl implements ReaderArrayService {
    private static final Logger logger = LogManager.getLogger();
    private static final Integer[] EMPTY_ARRAY = {};

    @Override
    public IntArray readFrom(String path, String delimPattern) throws ReaderArrayException {
        try (Scanner scanner = new Scanner(new File(path)).useDelimiter(delimPattern)) {
            IntStream.Builder builder = IntStream.builder();
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                if (NumberArrayValidator.isValidDigitLine(line)) {
                    String[] tokens = line.split(delimPattern);
                    for (String token : tokens) {
                        try {
                            int number = Integer.parseInt(token);
                            builder.add(number);
                        } catch (NumberFormatException e) {
                            logger.log(Level.ERROR, String.format("Cannot parse token: '%s'", token));
                        }
                    }
                } else {
                    logger.log(Level.ERROR, String.format("Cannot parse line: '%s'", line));
                }
            }
            int[] array = builder.build().toArray();
            return new IntArray(array);
        } catch (Exception e) {
            throw new ReaderArrayException(e);
        }
    }
}
