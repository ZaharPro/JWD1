package edu.epam.jwd.entity;

public interface NumberArray {
    int length();

    Number get(int index) throws IndexOutOfBoundsException;

    void set(Number number, int index) throws IndexOutOfBoundsException;
}
