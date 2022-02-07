package edu.epam.jwd.service;

import edu.epam.jwd.entity.NumberArray;
import edu.epam.jwd.exception.NumberArrayException;

import java.util.Comparator;

public interface NumberArrayService {
    Comparator<Number> DEFAULT_COMPARATOR = Comparator.comparingDouble(Number::doubleValue);

    Number[] asJavaArray(NumberArray array) throws NumberArrayException;

    NumberArray fromJavaArray(Number[] array) throws NumberArrayException;
}
