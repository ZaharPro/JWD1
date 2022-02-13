package edu.epam.jwd.oberver;

public interface Observable<E extends Event> {
    void addListener(Listener<E> listener);

    void removeListener(Listener<E> listener);
}
