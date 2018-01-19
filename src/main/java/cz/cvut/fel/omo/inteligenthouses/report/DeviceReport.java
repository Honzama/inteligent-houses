package cz.cvut.fel.omo.inteligenthouses.report;

import java.util.ArrayList;
import java.util.List;

import cz.cvut.fel.omo.inteligenthouses.simulation.device.Device;
import cz.cvut.fel.omo.inteligenthouses.simulation.device.Machine;

/**
 * Represents report of devices
 *
 * @author macekja7
 */
public class DeviceReport extends Report {

    /**
     * Creates new DeviceReport
     */
    public DeviceReport() {

    }

    /**
     * 
     * @param devices devices to be reported
     * @return list of strings with device reports
     */
    public static List<String> devicestoStrings(List<Device> devices) {
        List<String> strings = new ArrayList<String>();
        for (Device d : devices) {
            strings.add("  -" + d.toString());
            if (d instanceof Machine) {
                strings.addAll(SensorReport.sensorsToStrings(((Machine) d).getSensors()));
            }
            strings.add("");
        }
        return strings;
    }
}
