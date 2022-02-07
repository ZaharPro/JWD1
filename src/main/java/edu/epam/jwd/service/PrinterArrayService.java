package edu.epam.jwd.service;

import edu.epam.jwd.entity.NumberArray;
import edu.epam.jwd.exception.PrinterArrayServiceException;

public interface PrinterArrayService {
    void print(Appendable out, NumberArray array) throws PrinterArrayServiceException;
}
