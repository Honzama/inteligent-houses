package cz.cvut.fel.omo.inteligenthouses.factory;

import cz.cvut.fel.omo.inteligenthouses.config.*;
import java.util.concurrent.TimeUnit;

import cz.cvut.fel.omo.inteligenthouses.simulation.TimeFrame;

/**
 *
 * @author macekja7
 */
public class ConfigFactory extends Factory {

    private static ConfigFactory instance = null;

    private ConfigFactory() {
    }
    
    public StaticConfig createStaticConfig() {
        return new StaticConfig();
    }


    public TimeFrame createTimeFrame(int cycle, TimeUnit sourceUnits) {
        return new TimeFrame(cycle, sourceUnits);
    }

    public static ConfigFactory getInstance() {
        if (instance == null) {
            instance = new ConfigFactory();
        }
        return instance;
    }
}
