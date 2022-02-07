package edu.epam.jwd.service;

import edu.epam.jwd.entity.NumberArray;
import edu.epam.jwd.exception.CalculationArrayException;


public interface CalculationArrayService {
    Number findMin(NumberArray array) throws CalculationArrayException;

    Number findMax(NumberArray array) throws CalculationArrayException;

    Number sum(NumberArray array) throws CalculationArrayException;

    Number average(NumberArray array) throws CalculationArrayException;

    Number countPositive(NumberArray array) throws CalculationArrayException;

    Number countNegative(NumberArray array) throws CalculationArrayException;
}
