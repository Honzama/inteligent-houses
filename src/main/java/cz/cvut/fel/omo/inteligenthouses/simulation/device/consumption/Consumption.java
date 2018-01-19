package cz.cvut.fel.omo.inteligenthouses.simulation.device.consumption;

import cz.cvut.fel.omo.inteligenthouses.simulation.device.state.*;

/**
 * Represents a consuption of a device
 * @author macekja7
 */
public abstract class Consumption {

    private String name;
    private double idle;
    private double active;
    private String unit;
    private double consumed;

    /**
     * 
     * @param name name of the consumption
     * @param unit name of unit of the consumption
     * @param idle consumption in idle state
     * @param active consumption in active
     */
    public Consumption(String name, String unit, double idle, double active) {
        this.name = name;
        this.unit = unit;
        this.idle = idle;
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public double getIdle() {
        return idle;
    }

    public double getActive() {
        return active;
    }

    public String getUnit() {
        return unit;
    }

    public double getConsumptionForState(State state) {
        if (state instanceof Idle) {
            return idle;
        }
        if (state instanceof Active) {
            return active;
        }
        return 0;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIdle(double idle) {
        this.idle = idle;
    }

    public void setActive(double active) {
        this.active = active;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
    
    public void update(State state, int i) {
    	if (state instanceof Idle) {
    		consumed += idle*i;
        }
        if (state instanceof Active) {
        	consumed += active*i;
        }
    }
    
    public String toString() {
    	return name+" "+consumed+" "+unit;
    }
}
