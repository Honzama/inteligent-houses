package cz.cvut.fel.omo.inteligenthouses.simulation.device.consumption;

/**
 * Represents an electricity consumption
 *
 * @author macekja7
 */
public class Electricity extends Consumption {

    /**
     * Creates new electricity consumption
     *
     * @param idle value of consumption in idle state
     * @param active value of consumption in active state
     */
    public Electricity(double idle, double active) {
        super("Electricity", "Wh", idle, active);
    }
}
