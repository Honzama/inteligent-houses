package cz.cvut.fel.omo.inteligenthouses.report;

import java.util.ArrayList;
import java.util.List;

import cz.cvut.fel.omo.inteligenthouses.simulation.event.*;

/**
 * Represents report of events
 * @author macekja7
 */
public class EventReport extends Report {

    /**
     * Creates new EventReport and calls save
     * @param events 
     */
    public EventReport(List<Event> events) {
        saveReport(eventReport, eventsToStrings(events));
    }

    /**
     *
     * @param events events to be reported
     * @return list of strings with event reports
     */
    public static List<String> eventsToStrings(List<Event> events) {
        List<String> strings = new ArrayList<String>();
        strings.add("Events:");
        strings.add("");
        for (Event e : events) {
            strings.add(e.toString());
        }
        return strings;
    }
}
