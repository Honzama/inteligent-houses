package cz.cvut.fel.omo.inteligenthouses.console;

import cz.cvut.fel.omo.inteligenthouses.factory.ReportFactory;

/**
 *
 * @author macekja7
 */
public class ConsumptionReport extends Console {

    /**
     * Creates new ConsumptionReport console
     * @param back parent of this console
     */
    public ConsumptionReport(Console back) {
        super(consumptionReportName, back);
    }

    /**
     * Starts the console
     */
    @Override
    public void start() {
        System.out.println(getLineSeparator());
        ReportFactory.getInstance().createConsumptionReport(Init.getInstance().getConfig().getAllDevices());
        
        Init.getInstance().start();
    }

}
