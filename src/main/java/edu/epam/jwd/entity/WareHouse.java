package edu.epam.jwd.entity;

import edu.epam.jwd.exception.SuperException;
import edu.epam.jwd.repository.impl.ObservableMapRepository;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.function.Supplier;

public class WareHouse extends ObservableMapRepository<Integer, ArrayStatistics> {
    private static final WareHouse INSTANCE;

    static {
        try {
            INSTANCE = new WareHouse();
        } catch (SuperException e) {
            Logger logger = LogManager.getLogger();
            logger.log(Level.ERROR, e);
            throw new Error(e);
        }
    }

    public static WareHouse getInstance() {
        return INSTANCE;
    }

    private WareHouse() throws SuperException {
        super(new Supplier<Integer>() {
            private int seed = 0;

            @Override
            public Integer get() {
                return ++seed;
            }
        });
    }
}
