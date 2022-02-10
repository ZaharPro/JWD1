package edu.epam.jwd.service;

import edu.epam.jwd.entity.NumberArray;

import java.util.OptionalInt;


public interface CalculationArrayService {
    OptionalInt findMin(NumberArray array);

    OptionalInt findMax(NumberArray array);

    OptionalInt sum(NumberArray array);

    OptionalInt average(NumberArray array);

    long countPositive(NumberArray array);

    long countNegative(NumberArray array);
}
