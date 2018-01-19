package cz.cvut.fel.omo.inteligenthouses.console;

import cz.cvut.fel.omo.inteligenthouses.factory.ReportFactory;

/**
 *
 * @author macekja7
 */
public class ActivityAndUsageReport extends Console {

    /**
     * Creates new ActivityAndUsageReport console
     * @param back parent of this console
     */
    public ActivityAndUsageReport(Console back) {
        super(activityAndUsageReportName, back);
    }

    /**
     * Starts the console
     */
    @Override
    public void start() {
        System.out.println(getLineSeparator());
        ReportFactory.getInstance().createActivityAndUsageReport(Init.getInstance().getConfig().getSpecimens(), 
        														Init.getInstance().getConfig().getEventHandlerPool().getHistoryEvents());
        
        Init.getInstance().start();
    }

}
