package edu.epam.jwd.service.impl;

import edu.epam.jwd.entity.NumberArray;
import edu.epam.jwd.entity.impl.NumberArrayImpl;
import edu.epam.jwd.exception.NumberArrayException;
import edu.epam.jwd.service.NumberArrayService;

import java.util.Arrays;
import java.util.function.Predicate;

public class NumberArrayServiceImpl implements NumberArrayService {

    @Override
    public Number[] asJavaArray(NumberArray array) throws NumberArrayException {
        if (array == null) {
            throw new NumberArrayException(new NullPointerException("array should be not null"));
        }
        final int length = array.length();
        Number[] numbers = new Number[length];
        for (int i = 0; i < length; i++) {
            numbers[i] = array.get(i);
        }
        return numbers;
    }

    @Override
    public NumberArray fromJavaArray(Number[] array) {
        return new NumberArrayImpl(array);
    }

    @Override
    public NumberArray replaceIf(NumberArray array, Predicate<Number> predicate, Number replacement) throws NumberArrayException {
        Number[] numbers = asJavaArray(array);
        Number[] mapped = Arrays.stream(numbers)
                .map(number -> predicate.test(number) ? replacement : number)
                .map(Number::doubleValue)
                .toArray(Number[]::new);
        return fromJavaArray(mapped);
    }
}
