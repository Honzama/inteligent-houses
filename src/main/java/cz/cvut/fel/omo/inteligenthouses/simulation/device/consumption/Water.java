package cz.cvut.fel.omo.inteligenthouses.simulation.device.consumption;

/**
 * Represents a water consumption
 *
 * @author macekja7
 */
public class Water extends Consumption {

    /**
     * Creates new water consumption
     * @param idle value of consumption in idle state
     * @param active value of consumption in active state
     */
    public Water(double idle, double active) {
        super("Water", "L", idle, active);
    }

}
