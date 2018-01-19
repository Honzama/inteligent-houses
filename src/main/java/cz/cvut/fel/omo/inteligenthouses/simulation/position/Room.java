package cz.cvut.fel.omo.inteligenthouses.simulation.position;

import java.util.*;

import cz.cvut.fel.omo.inteligenthouses.simulation.device.*;

/**
 * Represents a room in the floor
 * @author macekja7
 */
public class Room {

    public Floor floor;
    public String name;
    public List<Device> devices;

    /**
     * Creates new Room
     * @param name
     */
    public Room(String name) {
        floor = null;
        this.name = name;
        devices = new ArrayList<Device>();
    }

    public Floor getFloor() {
        return floor;
    }

    public String getName() {
        return name;
    }

    public List<Device> getDevices() {
        return this.devices;
    }

    public void setFloor(Floor floor) {
        this.floor = floor;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDevices(List<Device> devices) {
        this.devices = devices;
    }

    /**
     * Adds given device to the list of this rooms's devices
     * @param device
     * @return <code>true</code> if add successful
     */
    public boolean addDevice(Device device) {
        return devices.add(device);
    }

    /**
     * Removes given device from the list of this rooms's devices
     * @param device
     * @return <code>true</code> if add successful
     */
    public boolean removeDevice(Device device) {
        return devices.remove(device);
    }
    
    public String toString() {
    	return name+" with "+devices.size()+" devices.";
    }
}
