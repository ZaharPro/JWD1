package edu.epam.jwd.service.impl;

import edu.epam.jwd.entity.NumberArray;
import edu.epam.jwd.exception.ReaderArrayException;
import edu.epam.jwd.service.NumberArrayService;
import edu.epam.jwd.service.ReaderArrayService;
import edu.epam.jwd.service.factory.NumberArrayServiceFactory;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ReaderArrayServiceImpl implements ReaderArrayService {
    private static final Logger logger = LogManager.getLogger();
    private static final Number[] EMPTY_ARRAY = {};

    @Override
    public NumberArray readFrom(String path, String delimPattern) throws ReaderArrayException {
        try (Scanner scanner = new Scanner(new File(path)).useDelimiter(delimPattern)) {
            ArrayList<Number> numbers = new ArrayList<>();
            while (scanner.hasNext()) {
                String token = scanner.next().trim();
                try {
                    Double number = Double.parseDouble(token);
                    numbers.add(number);
                } catch (NumberFormatException e) {
                    logger.log(Level.ERROR, String.format("Cannot parse token: '%s'", token));
                }
            }
            Number[] array = numbers.toArray(EMPTY_ARRAY);
            NumberArrayServiceFactory numberArrayServiceFactory = NumberArrayServiceFactory.getInstance();
            NumberArrayService service = numberArrayServiceFactory.getDefaultService();
            return service.fromJavaArray(array);
        } catch (Exception e) {
            throw new ReaderArrayException(e);
        }
    }
}
