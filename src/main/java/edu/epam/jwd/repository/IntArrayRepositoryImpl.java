package edu.epam.jwd.repository;

import edu.epam.jwd.entity.IntArray;
import edu.epam.jwd.repository.impl.ObservableListRepository;
import edu.epam.jwd.repository.impl.SpecificationImpl;
import edu.epam.jwd.service.CalculationArrayService;
import edu.epam.jwd.service.IntArrayService;
import edu.epam.jwd.service.factory.CalculationArrayServiceFactory;

import java.util.List;
import java.util.OptionalInt;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class IntArrayRepositoryImpl extends ObservableListRepository<Integer, IntArray> implements IntArrayRepository {
    private static final IntArrayRepositoryImpl INSTANCE = new IntArrayRepositoryImpl();

    public static IntArrayRepositoryImpl getInstance() {
        return INSTANCE;
    }

    private final CalculationArrayService service;

    private IntArrayRepositoryImpl() {
        super(new Supplier<Integer>() {
            private final AtomicInteger seed = new AtomicInteger();

            @Override
            public Integer get() {
                return seed.incrementAndGet();
            }
        });
        this.service = CalculationArrayServiceFactory.getInstance().getDefaultService();
    }

    @Override
    public List<IntArray> findArraysWhenAverageGreaterThat(int average) {
        SpecificationImpl<IntArray> specification = new SpecificationImpl<>();
        Predicate<IntArray> predicate = intArray -> {
            OptionalInt optional = service.average(intArray);
            return optional.isPresent() && optional.getAsInt() > average;
        };
        specification.getPredicates().add(predicate);
        return findAllBy(specification);
    }

    @Override
    public List<IntArray> findArraysWhenSumLessThat(int sum) {
        SpecificationImpl<IntArray> specification = new SpecificationImpl<>();
        Predicate<IntArray> predicate = intArray -> {
            OptionalInt optional = service.sum(intArray);
            return optional.isPresent() && optional.getAsInt() < sum;
        };
        specification.getPredicates().add(predicate);
        return findAllBy(specification);
    }

    @Override
    public List<IntArray> findArraysWhenMaxLessThat(int max) {
        SpecificationImpl<IntArray> specification = new SpecificationImpl<>();
        Predicate<IntArray> predicate = intArray -> {
            OptionalInt optional = service.findMax(intArray);
            return optional.isPresent() && optional.getAsInt() < max;
        };
        specification.getPredicates().add(predicate);
        return findAllBy(specification);
    }

    @Override
    public IntArray findFirstArrayWhenMaxFirstElement() {
        Specification<IntArray> specification = new SpecificationImpl<>();
        specification.setComparator(IntArrayService.BY_FIRST_ELEMENT);
        return findBy(specification);
    }

    @Override
    public List<IntArray> findFirst3ArraysSortedByLength() {
        Specification<IntArray> specification = new SpecificationImpl<>();
        specification.setComparator(IntArrayService.BY_LENGTH);
        specification.setLimit(3);
        return findAllBy(specification);
    }
}
