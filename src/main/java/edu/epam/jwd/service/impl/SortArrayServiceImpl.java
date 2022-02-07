package edu.epam.jwd.service.impl;

import edu.epam.jwd.entity.NumberArray;
import edu.epam.jwd.exception.SortArrayException;
import edu.epam.jwd.service.NumberArrayService;
import edu.epam.jwd.service.SortArrayService;
import edu.epam.jwd.service.factory.NumberArrayServiceFactory;

import java.util.Arrays;
import java.util.Comparator;

public class SortArrayServiceImpl implements SortArrayService {
    @Override
    public NumberArray sort(NumberArray array, Comparator<Number> comparator) throws SortArrayException {
        if (array == null) {
            throw new SortArrayException(new NullPointerException("array should be not null"));
        }
        if (comparator == null) {
            throw new SortArrayException(new NullPointerException("comparator should be not null"));
        }
        NumberArrayServiceFactory numberArrayServiceFactory = NumberArrayServiceFactory.getInstance();
        NumberArrayService service = numberArrayServiceFactory.getDefaultService();
        Number[] javaArray = service.asJavaArray(array);
        Arrays.sort(javaArray, comparator);
        return service.fromJavaArray(javaArray);
    }
}
