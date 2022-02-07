package edu.epam.jwd.service;

public interface ServiceFactory<Service> {
    Service getDefaultService();
}
