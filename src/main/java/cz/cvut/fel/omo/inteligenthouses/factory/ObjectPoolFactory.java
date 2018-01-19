package cz.cvut.fel.omo.inteligenthouses.factory;

import cz.cvut.fel.omo.inteligenthouses.config.Config;
import cz.cvut.fel.omo.inteligenthouses.simulation.event.EventHandlerPool;

/**
 *
 * @author macekja7
 */
public class ObjectPoolFactory extends Factory {

    private static ObjectPoolFactory instance;

    protected ObjectPoolFactory() {}
    
    public EventHandlerPool createEventHandlerPool(Config config) {
        EventHandlerPool pool = new EventHandlerPool();
        pool.setConfig(config);
        return pool;
    }

    public static ObjectPoolFactory getInstance() {
        if (instance == null) {
            instance = new ObjectPoolFactory();
        }
        return instance;
    }
}
