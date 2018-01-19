package cz.cvut.fel.omo.inteligenthouses.simulation.device.state;

/**
* Represents state of a device
 * @author macekja7
 */
public abstract class State {

    private String state;

    /**
     * Creates new State
     * @param state 
     */
    public State(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    
    public String toString() {
    	return state;
    }

}
