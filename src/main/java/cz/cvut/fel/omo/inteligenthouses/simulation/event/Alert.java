package cz.cvut.fel.omo.inteligenthouses.simulation.event;

import cz.cvut.fel.omo.inteligenthouses.simulation.device.Device;

/**
 * Represents an event with a single input
 * @author macekja7
 */
public class Alert extends Event {

    /**
     * Creates new Alert
     * @param input
     */
    public Alert(Object input) {
        super(input);
        this.setType("Alert");
    }
    
    @Override
    public String toString() {
    	String msg = getType()+" "+((Device) getInput()).getName()+" with state ("+((Device) getInput()).getState()+") in ("+((Device) getInput()).getPosition()+")";
    	if(getState() != -1 && getCycles() != -1) msg += " in "+getCycles()+" days and "+getState()+" hours of simulation";
    	return msg; 
    }
}
