package cz.cvut.fel.omo.inteligenthouses.report;

import java.util.ArrayList;
import java.util.List;

import cz.cvut.fel.omo.inteligenthouses.console.ActivityAndUsageReport;
import cz.cvut.fel.omo.inteligenthouses.simulation.event.Event;
import cz.cvut.fel.omo.inteligenthouses.simulation.event.Info;
import cz.cvut.fel.omo.inteligenthouses.simulation.specimen.Specimen;

/**
 * Represents report of specimen
 *
 * @author macekja7
 */
public class SpecimenReport extends Report {

    /**
     * Creates new SpecimenReport
     */
    public SpecimenReport(List<Specimen> specimens, List<Event> events) {
    	saveReport(specimenReport, specimensActivityToStrings(specimens, events));
    }

    /**
     * 
     * @return list of strings with specimen reports
     */
    public static List<String> specimensActivityToStrings(List<Specimen> specimens, List<Event> events) {
        List<String> strings = new ArrayList<String>();
        strings.add("Activities of Specimens:");
        strings.add("");
        for(Specimen s : specimens) {
        	int count = 0;
        	for(Event e : events) {
        		if(e instanceof Info && e.getInput() == s) {
        			count++;
        		}
        	}
        	strings.add(" Number of activies of "+s.getName()+" is: "+count);
        	strings.add("");
        }
        return strings;
    }
}
