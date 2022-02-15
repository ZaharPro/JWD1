package edu.epam.jwd.service.impl;

import edu.epam.jwd.entity.IntArray;
import edu.epam.jwd.exception.SuperException;
import edu.epam.jwd.service.IntArrayService;

import java.util.Arrays;
import java.util.function.Predicate;

public class IntArrayServiceImpl implements IntArrayService {

    public IntArray replaceIf(IntArray array, Predicate<Integer> predicate, Integer replacement) throws SuperException {
        if (array == null) {
            throw new SuperException("array should be not null");
        }
        int[] numbers = array.asJavaArray();
        int[] mapped = Arrays.stream(numbers)
                .map(number -> predicate.test(number) ? replacement : number)
                .toArray();
        return new IntArray(mapped);
    }
}
