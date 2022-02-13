package edu.epam.jwd.repository.impl;

import edu.epam.jwd.repository.RepositoryChangedEvent;
import edu.epam.jwd.oberver.Listener;
import edu.epam.jwd.repository.Entity;
import edu.epam.jwd.repository.ObservableRepository;
import edu.epam.jwd.repository.Repository;

import java.util.ArrayList;
import java.util.List;

public class ObservableRepositoryBase<Id, E extends Entity<Id>> extends RepositoryWrapper<Id, E>
        implements ObservableRepository<Id, E> {
    private final List<Listener<RepositoryChangedEvent>> listeners;

    public ObservableRepositoryBase(Repository<Id, E> innerRepository) {
        super(innerRepository);
        listeners = new ArrayList<>();
    }


    @Override
    public void addListener(Listener<RepositoryChangedEvent> listener) {
        if (listener == null) {
            throw new NullPointerException("listener");
        }
        listeners.add(listener);
    }

    @Override
    public void removeListener(Listener<RepositoryChangedEvent> listener) {
        if (listener == null) {
            throw new NullPointerException("listener");
        }
        listeners.remove(listener);
    }

    private void notifyListeners() {
        if (!listeners.isEmpty()) {
            RepositoryChangedEvent repositoryChangedEvent = new RepositoryChangedEvent(this);
            listeners.forEach(listener -> listener.accept(repositoryChangedEvent));
        }
    }

    /*@Override
    public E add(E entity) {
        E e = super.add(entity);
        notifyListeners();
        return e;
    }

    @Override
    public Iterable<E> addAll(Iterable<E> entities) {
        Iterable<E> es = super.addAll(entities);
        notifyListeners();
        return es;
    }

    @Override
    public void update(E entity) {
        super.update(entity);
        notifyListeners();
    }

    @Override
    public void updateAll(Iterable<E> entities) {
        super.updateAll(entities);
        notifyListeners();
    }

    @Override
    public void delete(E entity) {
        super.delete(entity);
        notifyListeners();
    }

    @Override
    public void deleteAll(Iterable<E> entities) {
        super.deleteAll(entities);
        notifyListeners();
    }*/

    @Override
    public void save() {
        super.save();
        notifyListeners();
    }
}
