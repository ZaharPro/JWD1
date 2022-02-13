package edu.epam.jwd.repository.impl;

import edu.epam.jwd.repository.Entity;

import java.util.function.Supplier;

public class ObservableListRepository<Id, E extends Entity<Id>> extends ObservableRepositoryBase<Id, E> {
    public ObservableListRepository(Supplier<Id> idGenerator) {
        super(new ListRepository<>(idGenerator));
    }
}
