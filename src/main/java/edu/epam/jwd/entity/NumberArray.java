package edu.epam.jwd.entity;

import edu.epam.jwd.exception.NumberArrayException;

public class NumberArray {
    private static void checkRange(int index, int length) throws NumberArrayException {
        if (index < 0 || index >= length) {
            Throwable cause = new IndexOutOfBoundsException(String.format("Index: %d, length: %d", index, length));
            throw new NumberArrayException(cause);
        }
    }

    private final int[] array;

    public NumberArray(int[] array) throws NumberArrayException {
        if (array == null) {
            throw new NumberArrayException(new NullPointerException("array should be not null"));
        }
        this.array = array.clone();
    }

    public int length() {
        return array.length;
    }

    public int get(int index) throws NumberArrayException {
        checkRange(index, length());
        return array[index];
    }

    public void set(int number, int index) throws NumberArrayException {
        checkRange(index, length());
        array[index] = number;
    }

    public int[] asJavaArray() throws NumberArrayException {
        return array.clone();
    }
}
