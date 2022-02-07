package edu.epam.jwd.service.factory;

import edu.epam.jwd.service.NumberArrayService;
import edu.epam.jwd.service.ServiceFactory;
import edu.epam.jwd.service.impl.NumberArrayServiceImpl;

public class NumberArrayServiceFactory implements ServiceFactory<NumberArrayService> {
    private static final NumberArrayServiceFactory INSTANCE = new NumberArrayServiceFactory();

    public static NumberArrayServiceFactory getInstance() {
        return INSTANCE;
    }

    private final NumberArrayServiceImpl DEFAULT = new NumberArrayServiceImpl();

    @Override
    public NumberArrayService getDefaultService() {
        return DEFAULT;
    }
}
