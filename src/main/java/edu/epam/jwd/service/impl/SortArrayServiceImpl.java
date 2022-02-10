package edu.epam.jwd.service.impl;

import edu.epam.jwd.entity.NumberArray;
import edu.epam.jwd.exception.SortArrayException;
import edu.epam.jwd.service.NumberArrayService;
import edu.epam.jwd.service.SortArrayService;
import edu.epam.jwd.service.factory.NumberArrayServiceFactory;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class SortArrayServiceImpl implements SortArrayService {
    @Override
    public NumberArray sort(NumberArray array, Comparator<Integer> comparator) throws SortArrayException {
        if (array == null) {
            throw new SortArrayException(new NullPointerException("array should be not null"));
        }
        if (comparator == null) {
            throw new SortArrayException(new NullPointerException("comparator should be not null"));
        }
        Integer[] boxed = Arrays.stream(array.asJavaArray())
                .boxed()
                .toArray(Integer[]::new);
        Arrays.sort(boxed, comparator);
        int[] result = Arrays.stream(boxed)
                .mapToInt(n -> n)
                .toArray();
        return new NumberArray(result);
    }
}
