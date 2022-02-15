package edu.epam.jwd.event;

import edu.epam.jwd.entity.IntArray;
import edu.epam.jwd.exception.SuperException;

public class ArrayChangeEvent extends Event {
    private final int number;
    private final int index;

    public ArrayChangeEvent(IntArray source, int number, int index) throws SuperException {
        super(source);
        this.number = number;
        this.index = index;
    }

    public int getNumber() {
        return number;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public IntArray getSource() {
        return (IntArray) super.getSource();
    }
}
