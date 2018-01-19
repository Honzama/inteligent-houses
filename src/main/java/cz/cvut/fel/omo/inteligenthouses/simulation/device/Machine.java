package cz.cvut.fel.omo.inteligenthouses.simulation.device;

import java.util.ArrayList;
import java.util.List;

import cz.cvut.fel.omo.inteligenthouses.simulation.position.Position;

/**
 * Represents a machine
 * @author macekja7
 */
public class Machine extends Device {

    private Documentation documentation;
    private List<Sensor> sensors;
    private List<Item> items;

    /**
     * Creates new Machine
     * @param name name of the machine
     * @param position position of the machine in the house (or outside)
     * @param documentation documentation of the machine
     */
    public Machine(String name, Position position, Documentation documentation) {
        super(name, position);
        this.documentation = documentation;
        sensors = new ArrayList<Sensor>();
        items = new ArrayList<Item>();
    }

    public Documentation getDocumentation() {
        return documentation;
    }

    public List<Sensor> getSensors() {
        return sensors;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setDocumentation(Documentation documentation) {
        this.documentation = documentation;
    }

    public void setSensors(List<Sensor> sensors) {
        this.sensors = sensors;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    /**
     * Adds given sensor to list of sensors of this machine; sets this machine to given sensor
     * @param sensor
     * @return <code>true</code> iff given sensor successfully added
     */
    public boolean addSensor(Sensor sensor) {
        sensor.setMachine(this);
        return sensors.add(sensor);
    }

    /**
     * Adds given item to list of items of this machine; sets this machine to given item
     * @param item
     * @return <code>true</code> iff given item successfully added
     */
    public boolean addItem(Item item) {
        item.setMachine(this);
        return items.add(item);
    }

    /**
     * Removes given sensor from list of sensors of this machine; sets null to given sensor
     * @param sensor
     * @return <code>true</code> iff given sensor successfully removed
     */
    public boolean removeSensor(Sensor sensor) {
        sensor.setMachine(null);
        return sensors.remove(sensor);
    }

    /**
     * Removes given item from list of items of this machine; sets null to given item
     * @param item
     * @return <code>true</code> iff given item successfully removed
     */
    public boolean removeItem(Item item) {
        item.setMachine(null);
        return items.remove(item);
    }

}
