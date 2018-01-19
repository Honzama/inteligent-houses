package cz.cvut.fel.omo.inteligenthouses.simulation.device;

/**
 * Represents an item
 * @author macekja7
 */
public class Item {

    private String name;
    private Machine machine;

    /**
     * Creates new Item
     * @param name name of the item
     */
    public Item(String name) {
        this.name = name;
        machine = null;
    }

    public String getName() {
        return name;
    }

    public Machine getMachine() {
        return machine;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMachine(Machine machine) {
        this.machine = machine;
    }
}
