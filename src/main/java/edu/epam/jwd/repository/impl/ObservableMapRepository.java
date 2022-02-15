package edu.epam.jwd.repository.impl;

import edu.epam.jwd.entity.Entity;

import java.util.function.Supplier;

public class ObservableMapRepository<Id, E extends Entity<Id>> extends ObservableRepositoryBase<Id, E> {
    public ObservableMapRepository(Supplier<Id> idGenerator) {
        super(new MapRepository<>(idGenerator));
    }
}
