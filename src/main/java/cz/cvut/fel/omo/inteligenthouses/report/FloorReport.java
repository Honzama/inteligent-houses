package cz.cvut.fel.omo.inteligenthouses.report;

import java.util.ArrayList;
import java.util.List;

import cz.cvut.fel.omo.inteligenthouses.simulation.position.Floor;

/**
 * Represents report of floors
 *
 * @author macekja7
 */
public class FloorReport extends Report {

    /**
     * Creates new FloorReport
     *
     * @param floors
     */
    public FloorReport(List<Floor> floors) {

    }

    /**
     *
     * @param floors floors to be reported
     * @return list of strings with floor reports
     */
    public static List<String> floorsToStrings(List<Floor> floors) {
        List<String> strings = new ArrayList<String>();
        for (Floor f : floors) {
            strings.add("  " + f.toString());
            strings.add("");
            strings.addAll(RoomReport.housesToStrings(f.getRooms()));
            strings.add("");
        }
        return strings;
    }
}
