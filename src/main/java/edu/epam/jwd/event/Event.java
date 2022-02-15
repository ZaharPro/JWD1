package edu.epam.jwd.event;

import edu.epam.jwd.exception.SuperException;

public class Event {
    private final Object source;

    public Event(Object source) throws SuperException {
        if (source == null) {
            throw new SuperException("source");
        }
        this.source = source;
    }

    public Object getSource() {
        return source;
    }
}
