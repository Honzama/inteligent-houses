package cz.cvut.fel.omo.inteligenthouses.console;

import cz.cvut.fel.omo.inteligenthouses.simulation.event.Event;

/**
 *
 * @author macekja7
 */
public class PrintEvents extends Console {

    /**
     * Creates new PrintEvents console
     * @param back parent of this console
     */
    public PrintEvents(Console back) {
        super(printEventsName, back);
    }

    /**
     * Starts the console
     */
    @Override
    public void start() {
        System.out.println(getLineSeparator());
        System.out.println("Number of active events in simulation: " + Init.getInstance().getConfig().getEventHandlerPool().getEvents().size() + "\r\n");

        for (Event e : Init.getInstance().getConfig().getEventHandlerPool().getEvents()) {
            System.out.println("- " + e);
        }

        getBack().run();
    }

}
