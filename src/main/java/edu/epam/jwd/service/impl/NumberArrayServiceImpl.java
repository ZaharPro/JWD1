package edu.epam.jwd.service.impl;

import edu.epam.jwd.entity.NumberArray;
import edu.epam.jwd.service.NumberArrayService;

import java.util.Arrays;
import java.util.function.Predicate;

public class NumberArrayServiceImpl implements NumberArrayService {

    public NumberArray replaceIf(NumberArray array, Predicate<Integer> predicate, Integer replacement) {
        int[] numbers = array.asJavaArray();
        int[] mapped = Arrays.stream(numbers)
                .map(number -> predicate.test(number) ? replacement : number)
                .toArray();
        return new NumberArray(mapped);
    }
}
