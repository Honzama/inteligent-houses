package cz.cvut.fel.omo.inteligenthouses.console;

import cz.cvut.fel.omo.inteligenthouses.factory.ReportFactory;

/**
 *
 * @author macekja7
 */
public class MenuEventReport extends Console {

    /**
     * Creates new MenuEventReport console
     * @param back parent of this console
     */
    public MenuEventReport(Console back) {
        super(eventReportingName, back);
    }

    /**
     * Starts the console
     */
    @Override
    public void start() {
    	System.out.println(getLineSeparator());
        ReportFactory.getInstance().createEventReport(Init.getInstance().getConfig().getEventHandlerPool().getHistoryEvents());

        Init.getInstance().start();
    }

}
