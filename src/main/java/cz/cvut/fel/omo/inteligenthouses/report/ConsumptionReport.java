package cz.cvut.fel.omo.inteligenthouses.report;

import java.util.ArrayList;
import java.util.List;

import cz.cvut.fel.omo.inteligenthouses.simulation.device.Device;
import cz.cvut.fel.omo.inteligenthouses.simulation.device.consumption.Consumption;

/**
 * Represents report of consumptions
 *
 * @author macekja7
 */
public class ConsumptionReport extends Report {

    /**
     * Creates new ConsumptionReport
     */
    public ConsumptionReport(List<Device> devices) {
    	saveReport(consumptionReport, deviceConsumptionToStrings(devices));
    }
    
    public static List<String> deviceConsumptionToStrings(List<Device> devices) {
    	List<String> strings = new ArrayList<String>();
    	strings.add("Device Consumption:");
    	strings.add("");
    	for(Device d : devices) {
    		strings.add(" "+d.toString());
    		for(Consumption c : d.getConsumption()) {
    			strings.add("  "+c.toString());
    		}
    		strings.add("");
    	}
    	return strings;
    }
}
