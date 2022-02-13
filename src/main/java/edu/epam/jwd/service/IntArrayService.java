package edu.epam.jwd.service;

import edu.epam.jwd.entity.IntArray;
import edu.epam.jwd.exception.NumberArrayException;

import java.util.Comparator;
import java.util.function.Predicate;

public interface IntArrayService {
    Comparator<Integer> DEFAULT_COMPARATOR = Comparator.nullsFirst(Integer::compare);
    Comparator<IntArray> BY_ID = (o1, o2) -> DEFAULT_COMPARATOR.compare(o1.getId(), o2.getId());
    Comparator<IntArray> BY_LENGTH = Comparator.comparingInt(IntArray::length);
    Comparator<IntArray> BY_FIRST_ELEMENT = (o1, o2) -> {
        if (o1.length() > 0 && o2.length() > 0) {
            return Integer.compare(o1.get(0), o2.get(0));
        } else {
            return BY_LENGTH.compare(o1, o2);
        }
    };

    IntArray replaceIf(IntArray array, Predicate<Integer> predicate, Integer replacement) throws NumberArrayException;
}
