package edu.epam.jwd.entity;

import edu.epam.jwd.oberver.Event;

public class ArrayChangedEvent extends Event {
    private final int number;
    private final int index;

    public ArrayChangedEvent(IntArray source, int number, int index) {
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
