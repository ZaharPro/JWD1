package edu.epam.jwd.repository;

import edu.epam.jwd.oberver.Event;

public class RepositoryChangedEvent extends Event {
    public RepositoryChangedEvent(Repository<?, ?> source) {
        super(source);
    }

    @Override
    public Repository<?, ?> getSource() {
        return (Repository<?, ?>) super.getSource();
    }
}
