package edu.epam.jwd.service;

import edu.epam.jwd.entity.NumberArray;
import edu.epam.jwd.exception.NumberArrayException;

import java.util.Comparator;
import java.util.function.Predicate;

public interface NumberArrayService {
    Comparator<Integer> DEFAULT_COMPARATOR = Integer::compare;

    NumberArray replaceIf(NumberArray array, Predicate<Integer> predicate, Integer replacement) throws NumberArrayException;
}
