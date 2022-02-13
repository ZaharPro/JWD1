package edu.epam.jwd.repository;

import edu.epam.jwd.oberver.Observable;

public interface ObservableRepository<Id, E extends Entity<Id>> extends Repository<Id, E>, Observable<RepositoryChangedEvent> {
}
