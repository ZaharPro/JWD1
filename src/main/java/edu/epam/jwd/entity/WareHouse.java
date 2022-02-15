package edu.epam.jwd.entity;

import edu.epam.jwd.repository.impl.ObservableMapRepository;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;

public class WareHouse extends ObservableMapRepository<Integer, ArrayStatistics> {
    private static final WareHouse INSTANCE = new WareHouse();

    public static WareHouse getInstance() {
        return INSTANCE;
    }

    private WareHouse() {
        super(new Supplier<Integer>() {
            private final AtomicInteger seed = new AtomicInteger();

            @Override
            public Integer get() {
                return seed.incrementAndGet();
            }
        });
    }
}
