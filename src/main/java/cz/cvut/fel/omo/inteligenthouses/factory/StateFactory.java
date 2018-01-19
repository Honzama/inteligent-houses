package cz.cvut.fel.omo.inteligenthouses.factory;

import cz.cvut.fel.omo.inteligenthouses.simulation.device.state.*;

/**
 *
 * @author macekja7
 */
public class StateFactory extends Factory {

    private static StateFactory instance = null;
    
    private StateFactory() {}

    public Off createOff() {
        return new Off();
    }

    public Idle createIdle() {
        return new Idle();
    }

    public Active createActive() {
        return new Active();
    }

    public Broken createBroken() {
        return new Broken();
    }

    public static StateFactory getInstance() {
        if (instance == null) {
            instance = new StateFactory();
        }
        return instance;
    }
}
