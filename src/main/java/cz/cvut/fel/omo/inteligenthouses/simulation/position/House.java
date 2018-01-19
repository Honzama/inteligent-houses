package cz.cvut.fel.omo.inteligenthouses.simulation.position;

import java.util.ArrayList;
import java.util.List;

import cz.cvut.fel.omo.inteligenthouses.simulation.device.Device;

/**
 * Represents a house
 * @author macekja7
 */
public class House extends Position {

    private List<Floor> floors;

    /**
     * Creates new House
     * @param address address of the house
     */
    public House(String address) {
        super(address);
        floors = new ArrayList<Floor>();
    }

    public List<Floor> getFloors() {
        return floors;
    }

    public void setFloors(List<Floor> floors) {
        this.floors = floors;
    }

    /**
     * Adds given floor to the list of this house's floors; sets this house to the floor
     * @param floor
     * @return <code>true</code> if add successful
     */
    public boolean addFloor(Floor floor) {
        floor.setHouse(this);
        return floors.add(floor);
    }

    /**
     * Removes given floor from the list of this house's floors; sets null to the floor
     * @param floor
     * @return <code>true</code> if remove successful
     */
    public boolean removeFloor(Floor floor) {
        floor.setHouse(null);
        return floors.remove(floor);
    }

    public boolean containsRoom(String name) {
        for (Floor floor : floors) {
            if (floor.containRoom(name)) {
                return true;
            }
        }
        return false;
    }

    public Room getRoom(String name) {
        for (Floor floor : floors) {
            if (floor.containRoom(name)) {
                return floor.getRoom(name);
            }
        }
        return null;
    }

    public List<Room> getRooms() {
        List<Room> rooms = new ArrayList<Room>();
        for (Floor floor : floors) {
            rooms.addAll(floor.getRooms());
        }
        return rooms;
    }
    
    public List<Device> getDevices() {
    	List<Device> devices = new ArrayList<Device>();
    	for(Room room : getRooms()) {
    		devices.addAll(room.getDevices());
    	}
    	return devices;
    }
    
    public String toString() {
    	return "House on address \'"+getAddress()+"\' with "+floors.size()+" floors";
    }
}
