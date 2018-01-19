package cz.cvut.fel.omo.inteligenthouses.console;

import cz.cvut.fel.omo.inteligenthouses.factory.ReportFactory;

/**
 *
 * @author macekja7
 */
public class HouseConfigurationReport extends Console {

    /**
     * Creates new HouseConfigurationReport
     * @param back parent console to this one
     */
    public HouseConfigurationReport(Console back) {
        super(houseConfigurationReportName, back);
    }

    /**
     * Starts the console
     */
    @Override
    public void start() {
        System.out.println(getLineSeparator());
        ReportFactory.getInstance().createHouseConfigReport(Init.getInstance().getConfig().getHouses(), Init.getInstance().getConfig().getSpecimens());

        Init.getInstance().start();
    }

}
