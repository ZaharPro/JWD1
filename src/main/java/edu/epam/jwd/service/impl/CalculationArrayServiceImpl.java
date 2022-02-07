package edu.epam.jwd.service.impl;

import edu.epam.jwd.entity.NumberArray;
import edu.epam.jwd.exception.CalculationArrayException;
import edu.epam.jwd.service.CalculationArrayService;
import edu.epam.jwd.service.NumberArrayService;
import edu.epam.jwd.service.factory.NumberArrayServiceFactory;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class CalculationArrayServiceImpl implements CalculationArrayService {

    private Stream<Number> streamFrom(NumberArray array) {
        NumberArrayService service = NumberArrayServiceFactory.getInstance().getDefaultService();
        return Arrays.stream(service.asJavaArray(array));
    }

    @Override
    public Number findMin(NumberArray array) throws CalculationArrayException {
        Stream<Number> stream = streamFrom(array);
        Optional<Number> min = stream.min(NumberArrayService.DEFAULT_COMPARATOR);
        return min.orElseThrow(() -> new CalculationArrayException("min value not found"));
    }

    @Override
    public Number findMax(NumberArray array) throws CalculationArrayException {
        Stream<Number> stream = streamFrom(array);
        Optional<Number> max = stream.max(NumberArrayService.DEFAULT_COMPARATOR);
        return max.orElseThrow(() -> new CalculationArrayException("max value not found"));
    }

    @Override
    public Number sum(NumberArray array) throws CalculationArrayException {
        Stream<Number> stream = streamFrom(array);
        Optional<Number> max = stream.reduce((n1, n2) -> n1.doubleValue() + n2.doubleValue());
        return max.orElseThrow(() -> new CalculationArrayException("unreal calculate sum"));
    }

    @Override
    public Number average(NumberArray array) throws CalculationArrayException {
        return sum(array).doubleValue() / array.length();
    }

    @Override
    public Number countPositive(NumberArray array) throws CalculationArrayException {
        Stream<Number> stream = streamFrom(array);
        return stream.filter(number -> number.doubleValue() > 0).count();
    }

    @Override
    public Number countNegative(NumberArray array) throws CalculationArrayException {
        Stream<Number> stream = streamFrom(array);
        return stream.filter(number -> number.doubleValue() > 0).count();
    }
}
