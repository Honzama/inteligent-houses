package cz.cvut.fel.omo.inteligenthouses.factory;

import cz.cvut.fel.omo.inteligenthouses.simulation.position.*;

/**
 *
 * @author macekja7
 */
public class PositionFactory extends Factory {

    private static PositionFactory instance = null;

    private PositionFactory() {
    }

    public Outside getOutside() {
        return Outside.getInstance();
    }

    public House createHouse(String adress) {
        return new House(adress);
    }

    public static PositionFactory getInstance() {
        if (instance == null) {
            instance = new PositionFactory();
        }
        return instance;
    }
}
