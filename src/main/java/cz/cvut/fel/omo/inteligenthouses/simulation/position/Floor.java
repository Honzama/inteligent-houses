package cz.cvut.fel.omo.inteligenthouses.simulation.position;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a single floor of the house
 * @author macekja7
 */
public class Floor {

    private House house;
    private int number;
    private List<Room> rooms;

    /**
     * Creates new Floor
     * @param number number of the floor
     */
    public Floor(int number) {
        this.house = null;
        this.number = number;
        rooms = new ArrayList<Room>();
    }

    public House getHouse() {
        return house;
    }

    public int getNumber() {
        return number;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    /**
     * Adds room to the floor; sets this floor to the room
     * @param room
     * @return <code>true</code> if add successful
     */
    public boolean addRoom(Room room) {
        room.setFloor(this);
        return rooms.add(room);
    }

    /**
     * Removes a room from the floor; sets null to the room
     * @param room
     * @return <code>true</code> if remove successful
     */
    public boolean removeRoom(Room room) {
        room.setFloor(null);
        return rooms.remove(room);
    }

    public boolean containRoom(String name) {
        for (Room room : rooms) {
            if (room.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public Room getRoom(String name) {
        for (Room room : rooms) {
            if (room.getName().equals(name)) {
                return room;
            }
        }
        return null;
    }
    
    public String toString() {
    	return number+". Floor";
    }
}
