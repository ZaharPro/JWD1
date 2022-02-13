package edu.epam.jwd.oberver;

public interface Listener<E extends Event> {
    void accept(E event);
}
