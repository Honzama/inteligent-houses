package cz.cvut.fel.omo.inteligenthouses.report;

import java.util.ArrayList;
import java.util.List;

import cz.cvut.fel.omo.inteligenthouses.simulation.position.House;
import cz.cvut.fel.omo.inteligenthouses.simulation.specimen.Specimen;

/**
 * Represents report of houses
 * @author macekja7
 */
public class HouseReport extends Report {

    /**
     * Creates new HouseReport and calls save
     * @param houses houses to be reported
     * @param people people to be reported
     */
    public HouseReport(List<House> houses, List<Specimen> people) {
        saveReport(houseReport, housesToStrings(houses, people));
    }

    /**
     *
     * @param houses houses to be reported
     * @param people people to be reported
     * @return list of strings with houser reports
     */
    public static List<String> housesToStrings(List<House> houses, List<Specimen> people) {
        List<String> strings = new ArrayList<String>();
        for (House h : houses) {
            strings.add(h.toString());
            strings.add("");
            strings.add(" Devices in floors:");
            strings.add("");
            strings.addAll(FloorReport.floorsToStrings(h.getFloors()));
            strings.add(" Specimens:");
            strings.add("");
            for (Specimen s : people) {
                if (s.getActualPosition() == h) {
                    strings.add(" -" + s.toString());
                }
            }
            strings.add("");
        }
        return strings;
    }
}
