package edu.epam.jwd.service.factory;

import edu.epam.jwd.service.IntArrayService;
import edu.epam.jwd.service.ServiceFactory;
import edu.epam.jwd.service.impl.IntArrayServiceImpl;

public class NumberArrayServiceFactory implements ServiceFactory<IntArrayService> {
    private static final NumberArrayServiceFactory INSTANCE = new NumberArrayServiceFactory();

    public static NumberArrayServiceFactory getInstance() {
        return INSTANCE;
    }

    private final IntArrayServiceImpl DEFAULT = new IntArrayServiceImpl();

    @Override
    public IntArrayService getDefaultService() {
        return DEFAULT;
    }
}
