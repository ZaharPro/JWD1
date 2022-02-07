package edu.epam.jwd.service.impl;

import edu.epam.jwd.entity.NumberArray;
import edu.epam.jwd.exception.PrinterArrayServiceException;
import edu.epam.jwd.service.NumberArrayService;
import edu.epam.jwd.service.PrinterArrayService;
import edu.epam.jwd.service.factory.NumberArrayServiceFactory;

import java.io.IOException;
import java.util.Arrays;

public class PrinterArrayServiceImpl implements PrinterArrayService {
    @Override
    public void print(Appendable out, NumberArray array) throws PrinterArrayServiceException {
        try {
            NumberArrayServiceFactory numberArrayServiceFactory = NumberArrayServiceFactory.getInstance();
            NumberArrayService service = numberArrayServiceFactory.getDefaultService();
            Number[] numbers = service.asJavaArray(array);
            out.append(Arrays.toString(numbers));
        } catch (IOException e) {
            throw new PrinterArrayServiceException(e);
        }
    }
}
