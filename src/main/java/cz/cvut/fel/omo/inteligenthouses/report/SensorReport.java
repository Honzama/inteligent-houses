package cz.cvut.fel.omo.inteligenthouses.report;

import java.util.ArrayList;
import java.util.List;

import cz.cvut.fel.omo.inteligenthouses.simulation.device.Sensor;

/**
 * Represents report of sensors
 * @author macekja7
 */
public class SensorReport extends Report {

    /**
     * Creates new SensorReport
     */
    public SensorReport() {

    }

    /**
     *
     * @param sensors sensors to be reported
     * @return list of strings with sensor reports
     */
    public static List<String> sensorsToStrings(List<Sensor> sensors) {
        List<String> strings = new ArrayList<String>();
        for (Sensor s : sensors) {
            strings.add("    -" + s.toString());
        }
        return strings;
    }
}
