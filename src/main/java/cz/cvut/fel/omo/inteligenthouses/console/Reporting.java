package cz.cvut.fel.omo.inteligenthouses.console;

/**
 *
 * @author macekja7
 */
public class Reporting extends Console {

    /**
     * Reates new Reporting console
     * @param back parent of this console
     */
    public Reporting(Console back) {
        super(reportingName, back);
    }

    /**
     * Starts the console and adds every report console under it
     */
    @Override
    public void start() {
        if (getConsoles().isEmpty()) {
            addConsole(new HouseConfigurationReport(this));
            addConsole(new MenuEventReport(this));
            addConsole(new ActivityAndUsageReport(this));
            addConsole(new ConsumptionReport(this));
            //addConsole(new SavingsReport(this));
        }

        run();
    }

}
