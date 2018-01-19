package cz.cvut.fel.omo.inteligenthouses.simulation.event;

import cz.cvut.fel.omo.inteligenthouses.simulation.device.Device;
import cz.cvut.fel.omo.inteligenthouses.simulation.specimen.Specimen;

/**
 * Represents an event with an input and an output
 * @author macekja7
 */
public class Info extends Event {

    /**
     * Creates new Info
     * @param input
     * @param output
     */
    public Info(Object input, Object output) {
        super(input, output);
        this.setType("Info");
    }

	@Override
	public String toString() {
		String msg = getType()+" "+((Specimen) getInput()).getName()+" used ("+((Device) getOutput()).getName()+") in ("+((Device) getOutput()).getPosition()+")";
		if(getState() != -1 && getCycles() != -1) msg += " in "+getCycles()+" days and "+getState()+" hours of simulation";
    	return msg;
    }
    
}
