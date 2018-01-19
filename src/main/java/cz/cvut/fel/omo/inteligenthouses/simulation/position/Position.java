package cz.cvut.fel.omo.inteligenthouses.simulation.position;

/**
 * Abstract class representing a position
 * @author macekja7
 */
public abstract class Position {

    private String address;

    /**
     * Creates new position
     * @param address address of the position
     */
    public Position(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    public String toString() {
    	return address;
    }
}
