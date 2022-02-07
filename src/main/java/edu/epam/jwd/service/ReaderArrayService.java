package edu.epam.jwd.service;

import edu.epam.jwd.entity.NumberArray;
import edu.epam.jwd.exception.ReaderArrayException;

public interface ReaderArrayService {
    String DEFAULT_DELIM_PATTERN = "(,|\\s|\\n)+";

    NumberArray readFrom(String path, String delimPattern) throws ReaderArrayException;
}
