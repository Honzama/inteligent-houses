package cz.cvut.fel.omo.inteligenthouses.factory;

import cz.cvut.fel.omo.inteligenthouses.simulation.device.consumption.*;

/**
 *
 * @author macekja7
 */
public class ConsumptionFactory extends Factory {

    private static ConsumptionFactory instance = null;

    private ConsumptionFactory() {}
    
    public Electricity createElectricity(double idle, double active) {
        return new Electricity(idle, active);
    }

    public Water createWater(double idle, double active) {
        return new Water(idle, active);
    }

    public static ConsumptionFactory getInstance() {
        if (instance == null) {
            instance = new ConsumptionFactory();
        }
        return instance;
    }
}
