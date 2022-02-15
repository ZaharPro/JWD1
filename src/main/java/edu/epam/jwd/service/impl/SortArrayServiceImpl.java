package edu.epam.jwd.service.impl;

import edu.epam.jwd.entity.IntArray;
import edu.epam.jwd.exception.SuperException;
import edu.epam.jwd.service.SortArrayService;

import java.util.Arrays;
import java.util.Comparator;

public class SortArrayServiceImpl implements SortArrayService {
    @Override
    public IntArray sort(IntArray array, Comparator<Integer> comparator) throws SuperException {
        if (array == null) {
            throw new SuperException("array should be not null");
        }
        if (comparator == null) {
            throw new SuperException("comparator should be not null");
        }
        Integer[] boxed = Arrays.stream(array.asJavaArray())
                .boxed()
                .toArray(Integer[]::new);
        Arrays.sort(boxed, comparator);
        int[] result = Arrays.stream(boxed)
                .mapToInt(n -> n)
                .toArray();
        return new IntArray(result);
    }
}
