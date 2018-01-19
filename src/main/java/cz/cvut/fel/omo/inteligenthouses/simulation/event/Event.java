package cz.cvut.fel.omo.inteligenthouses.simulation.event;

import cz.cvut.fel.omo.inteligenthouses.simulation.device.Device;
import cz.cvut.fel.omo.inteligenthouses.simulation.specimen.Specimen;

/**
 * Abstract class representing an event based on given params
 * @author macekja7
 */
public abstract class Event {

    private Specimen inputSpecimen;
    private Device inputDevice;
    private Specimen outputSpecimen;
    private Device outputDevice;
    private String type;
    private int cycles;
    private int state;

    /**
     * Creates new Event (info)
     * @param input 
     * @param output
     */
    public Event(Object input, Object output) {
        setInput(input);
        setOutput(output);
        cycles = -1;
        state = -1;
    }

    /**
     * Creates new Event (alert)
     * @param input
     */
    public Event(Object input) {
        setInput(input);
    }

    public Object getInput() {
        if (inputSpecimen != null) {
            return inputSpecimen;
        }
        if (inputDevice != null) {
            return inputDevice;
        }
        return null;
    }

    public Object getOutput() {
        if (outputSpecimen != null) {
            return outputSpecimen;
        }
        if (outputDevice != null) {
            return outputDevice;
        }
        return null;
    }

    public String getType() {
        return type;
    }
    
    public int getCycles() {
    	return cycles;
    }
    
    public int getState() {
    	return state;
    }
    
    public void setInput(Object input) {
        if (input instanceof Specimen) {
            this.inputSpecimen = (Specimen) input;
        }
        if (input instanceof Device) {
            this.inputDevice = (Device) input;
        }
    }

    public void setOutput(Object output) {
        if (output instanceof Specimen) {
            this.outputSpecimen = (Specimen) output;
        }
        if (output instanceof Device) {
            this.outputDevice = (Device) output;
        }
    }

    public void setType(String type) {
        this.type = type;
    }
    
    public void setCycles(int cycle) { 
    	this.cycles = cycle; 
    }
    
    public void setState(int state) { 
    	this.state = state;
    }
    
    public abstract String toString();
}
