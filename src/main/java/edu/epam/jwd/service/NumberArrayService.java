package edu.epam.jwd.service;

import edu.epam.jwd.entity.NumberArray;
import edu.epam.jwd.exception.NumberArrayException;

import java.util.Comparator;
import java.util.function.Predicate;

public interface NumberArrayService {
    Comparator<Number> DEFAULT_COMPARATOR = Comparator.comparingDouble(Number::doubleValue);

    Number[] asJavaArray(NumberArray array) throws NumberArrayException;

    NumberArray fromJavaArray(Number[] array) throws NumberArrayException;

    NumberArray replaceIf(NumberArray array, Predicate<Number> predicate,  Number replacement) throws NumberArrayException;
}
