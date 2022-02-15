package edu.epam.jwd.repository.impl;

import edu.epam.jwd.event.RepositoryChangeEvent;
import edu.epam.jwd.exception.SuperException;
import edu.epam.jwd.observer.EventListener;
import edu.epam.jwd.entity.Entity;
import edu.epam.jwd.repository.ObservableRepository;
import edu.epam.jwd.repository.Repository;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class ObservableRepositoryBase<Id, E extends Entity<Id>> extends RepositoryWrapper<Id, E>
        implements ObservableRepository<Id, E> {
    private final List<EventListener<RepositoryChangeEvent>> listeners;

    public ObservableRepositoryBase(Repository<Id, E> innerRepository) throws SuperException {
        super(innerRepository);
        listeners = new ArrayList<>();
    }


    @Override
    public void addListener(EventListener<RepositoryChangeEvent> listener) throws SuperException {
        if (listener == null) {
            throw new SuperException("listener");
        }
        listeners.add(listener);
    }

    @Override
    public void removeListener(EventListener<RepositoryChangeEvent> listener) throws SuperException {
        if (listener == null) {
            throw new SuperException("listener");
        }
        listeners.remove(listener);
    }

    private void notifyListeners() throws SuperException {
        if (!listeners.isEmpty()) {
            RepositoryChangeEvent repositoryChangeEvent = new RepositoryChangeEvent(this);
            listeners.forEach(listener -> listener.accept(repositoryChangeEvent));
        }
    }

    @Override
    public void save() {
        super.save();
        try {
            notifyListeners();
        } catch (SuperException e) {
            Logger logger = LogManager.getLogger();
            logger.log(Level.ERROR, e);
        }
    }
}
