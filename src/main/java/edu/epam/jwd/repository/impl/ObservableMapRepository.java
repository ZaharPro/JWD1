package edu.epam.jwd.repository.impl;

import edu.epam.jwd.entity.Entity;
import edu.epam.jwd.exception.SuperException;

import java.util.function.Supplier;

public class ObservableMapRepository<Id, E extends Entity<Id>> extends ObservableRepositoryBase<Id, E> {
    public ObservableMapRepository(Supplier<Id> idGenerator) throws SuperException {
        super(new MapRepository<>(idGenerator));
    }
}
