package edu.epam.jwd.oberver;

public class Event {
    private final Object source;

    public Event(Object source) {
        if (source == null) {
            throw new NullPointerException("source");
        }
        this.source = source;
    }

    public Object getSource() {
        return source;
    }
}
