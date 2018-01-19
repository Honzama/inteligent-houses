package cz.cvut.fel.omo.inteligenthouses.simulation.device;

import java.util.*;

import cz.cvut.fel.omo.inteligenthouses.factory.StateFactory;
import cz.cvut.fel.omo.inteligenthouses.simulation.device.consumption.Consumption;
import cz.cvut.fel.omo.inteligenthouses.simulation.device.state.*;
import cz.cvut.fel.omo.inteligenthouses.simulation.position.Position;
import cz.cvut.fel.omo.inteligenthouses.simulation.specimen.Specimen;

/**
 * Abstract class representing common data for all devices.
 * @author macekja7
 */
public abstract class Device {

    private String name;
    private State state;
    private State previousState;
    private Position position;
    private List<Consumption> consumption;
    private Specimen user;

    /**
     * Creates new Device
     * @param name name of the device
     * @param position position in the house (or outside)
     */
    public Device(String name, Position position) {
        this.name = name;
        state = StateFactory.getInstance().createOff();
        previousState = StateFactory.getInstance().createOff();
        this.position = position;
        consumption = new ArrayList<Consumption>();
    }

    public String getName() {
        return name;
    }

    public State getState() {
        return state;
    }

    public Position getPosition() {
        return position;
    }

    public List<Consumption> getConsumption() {
        return consumption;
    }

    public Specimen getUser() {
        return user;
    }

    /**
     * 
     * @return previous functional state 
     */
    public State getPreviousState() {
        return previousState;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public void setState(State state) {
        previousState = this.state;
        this.state = state;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setConsumption(List<Consumption> consumption) {
        this.consumption = consumption;
    }

    public void setUser(Specimen user) {
        this.user = user;
    }
    
    public void setNextState() {
    	if(state instanceof Broken) {
    		turnRepair();
    	}
    	if(state instanceof Active) {
    		turnDeactive();
    	}
    	if(state instanceof Idle) {
    		if(previousState instanceof Active) {
    			turnOff();
    		} 
    		if(previousState instanceof Off) {
    			turnActive();
    		}
    	}
    	if(state instanceof Off) {
    		turnOn();
    	}
    }
    
    /**
     * Turns the device on (Idle state)
     */
    public void turnOn() {
        setState(StateFactory.getInstance().createIdle());
    }

    /**
     * Turns the device off (Off state)
     */
    public void turnOff() {
        setState(StateFactory.getInstance().createOff());
    }

    /**
     * Turns the device active (Active state)
     */
    public void turnActive() {
        setState(StateFactory.getInstance().createActive());
    }

    /**
     * Deactives the device (Idle state)
     */
    public void turnDeactive() {
        setState(StateFactory.getInstance().createIdle());
    }

    /**
     * Repairs the device (Off state)
     */
    public void turnRepair() {
        setState(StateFactory.getInstance().createOff());
    }

    /**
     * Changes state of the device to a previous state
     */
    public void rollbackState() {
    		state = previousState;
    }
    
    public boolean addConsumption(Consumption consumption) {
        return this.consumption.add(consumption);
    }

    public boolean removeConsumption(Consumption consumption) {
        return this.consumption.remove(consumption);
    }
    
    public void updateConsumption(int i) {
    	for(Consumption c : consumption) {
    		c.update(state, i);
    	}
    }
    
    public String toString() {
    	return name+" with state ("+state+") in ("+position+")";
    }
}
