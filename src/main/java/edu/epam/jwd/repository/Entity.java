package edu.epam.jwd.repository;

public interface Entity<Id> {
    Id getId();

    void setId(Id id);
}
