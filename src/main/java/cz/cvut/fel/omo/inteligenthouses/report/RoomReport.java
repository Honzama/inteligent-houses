package cz.cvut.fel.omo.inteligenthouses.report;

import java.util.ArrayList;
import java.util.List;

import cz.cvut.fel.omo.inteligenthouses.simulation.position.Room;

/**
 * Represents report of rooms
 * @author macekja7
 */
public class RoomReport extends Report {

    /**
     * Creates new RoomReport
     * @param rooms
     */
    public RoomReport(List<Room> rooms) {

    }

    /**
     * 
     * @param rooms rooms to be reported 
     * @return list of strings with room reports
     */
    public static List<String> housesToStrings(List<Room> rooms) {
        List<String> strings = new ArrayList<String>();
        for (Room r : rooms) {
            strings.addAll(DeviceReport.devicestoStrings(r.getDevices()));
        }
        return strings;
    }
}
