package edu.epam.jwd.service;

import edu.epam.jwd.entity.NumberArray;
import edu.epam.jwd.exception.SortArrayException;

import java.util.Comparator;

public interface SortArrayService {
    NumberArray sort(NumberArray array, Comparator<Integer> comparator) throws SortArrayException;
}
