package edu.epam.jwd.service;

import edu.epam.jwd.entity.IntArray;
import edu.epam.jwd.exception.SuperException;

public interface PrinterArrayService {
    void print(Appendable out, IntArray array) throws SuperException;
}
