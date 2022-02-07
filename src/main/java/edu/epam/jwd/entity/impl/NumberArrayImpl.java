package edu.epam.jwd.entity.impl;

import edu.epam.jwd.entity.NumberArray;
import edu.epam.jwd.exception.NumberArrayException;

public class NumberArrayImpl implements NumberArray {
    private static void checkRange(int index, int length) throws NumberArrayException {
        if (index < 0 || index >= length) {
            Throwable cause = new IndexOutOfBoundsException(String.format("Index: %d, length: %d", index, length));
            throw new NumberArrayException(cause);
        }
    }

    private final Number[] array;

    public NumberArrayImpl(Number[] array) throws NumberArrayException {
        if (array == null) {
            throw new NumberArrayException(new NullPointerException("array should be not null"));
        }
        this.array = array;
    }

    @Override
    public int length() {
        return array.length;
    }

    @Override
    public Number get(int index) throws NumberArrayException {
        checkRange(index, length());
        return array[index];
    }

    @Override
    public void set(Number number, int index) throws NumberArrayException {
        checkRange(index, length());
        array[index] = number;
    }
}
