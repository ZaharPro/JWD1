package edu.epam.jwd.entity;

import edu.epam.jwd.exception.NumberArrayException;
import edu.epam.jwd.oberver.Listener;
import edu.epam.jwd.oberver.Observable;
import edu.epam.jwd.repository.Entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntArray implements Entity<Integer>, Observable<ArrayChangedEvent> {
    private static void checkRange(int index, int length) throws NumberArrayException {
        if (index < 0 || index >= length) {
            Throwable cause = new IndexOutOfBoundsException(String.format("Index: %d, length: %d", index, length));
            throw new NumberArrayException(cause);
        }
    }

    private List<Listener<ArrayChangedEvent>> listeners;
    private Integer id;
    private final int[] array;

    public IntArray(int[] array) throws NumberArrayException {
        if (array == null) {
            throw new NumberArrayException(new NullPointerException("array should be not null"));
        }
        this.array = array.clone();
        this.listeners = new ArrayList<>();
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
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
        onElementChanged(number, index);
    }

    private void onElementChanged(int number, int index) {
        if (!listeners.isEmpty()) {
            ArrayChangedEvent event = new ArrayChangedEvent(this, number, index);
            listeners.forEach(listener -> listener.accept(event));
        }
    }

    public int[] asJavaArray() throws NumberArrayException {
        return array.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntArray that = (IntArray) o;
        return Arrays.equals(array, that.array);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(array);
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("NumberArray{")
                .append("array=").append(Arrays.toString(array))
                .append('}')
                .toString();
    }

    @Override
    public void addListener(Listener<ArrayChangedEvent> listener) {
        if (listener == null) {
            throw new NullPointerException("listener");
        }
        listeners.add(listener);
    }

    @Override
    public void removeListener(Listener<ArrayChangedEvent> listener) {
        if (listener == null) {
            throw new NullPointerException("listener");
        }
        listeners.remove(listener);
    }
}
