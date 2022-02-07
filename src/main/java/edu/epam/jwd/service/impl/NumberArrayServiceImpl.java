package edu.epam.jwd.service.impl;

import edu.epam.jwd.entity.NumberArray;
import edu.epam.jwd.entity.impl.NumberArrayImpl;
import edu.epam.jwd.exception.NumberArrayException;
import edu.epam.jwd.service.NumberArrayService;

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
}
