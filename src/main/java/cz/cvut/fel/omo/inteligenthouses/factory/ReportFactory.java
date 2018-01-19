package cz.cvut.fel.omo.inteligenthouses.factory;

import java.util.List;

import cz.cvut.fel.omo.inteligenthouses.report.*;
import cz.cvut.fel.omo.inteligenthouses.simulation.device.Device;
import cz.cvut.fel.omo.inteligenthouses.simulation.event.Event;
import cz.cvut.fel.omo.inteligenthouses.simulation.position.House;
import cz.cvut.fel.omo.inteligenthouses.simulation.specimen.Specimen;

/**
*
* @author macekja7
*/
public class ReportFactory extends Factory {
	private static ReportFactory instance = null;
	
	public EventReport createEventReport(List<Event> events) {
		return new EventReport(events);
	}
	
	public HouseReport createHouseConfigReport(List<House> houses, List<Specimen> people) {
		return new HouseReport(houses, people);
	}
	
	public SpecimenReport createActivityAndUsageReport(List<Specimen> specimens, List<Event> events) {
		return new SpecimenReport(specimens, events);
	}
	
	public ConsumptionReport createConsumptionReport(List<Device> devices) {
		return new ConsumptionReport(devices);
	}
	
	public static ReportFactory getInstance() {
		if(instance == null) {
			instance = new ReportFactory();
		}
		return instance;
	}
}
