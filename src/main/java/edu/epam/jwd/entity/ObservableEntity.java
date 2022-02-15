package edu.epam.jwd.entity;

import edu.epam.jwd.oberver.Event;
import edu.epam.jwd.oberver.Observable;

public interface ObservableEntity<Id, E extends Event> extends Entity<Id>, Observable<E> {
}
