package edu.epam.jwd.entity;

import edu.epam.jwd.exception.NumberArrayException;

public interface NumberArray {
    int length();

    Number get(int index) throws NumberArrayException;

    void set(Number number, int index) throws NumberArrayException;
}
