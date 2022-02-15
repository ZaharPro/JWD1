package edu.epam.jwd.event;

import edu.epam.jwd.exception.SuperException;
import edu.epam.jwd.repository.Repository;

public class RepositoryChangeEvent extends Event {
    public RepositoryChangeEvent(Repository<?, ?> source) throws SuperException {
        super(source);
    }

    @Override
    public Repository<?, ?> getSource() {
        return (Repository<?, ?>) super.getSource();
    }
}
