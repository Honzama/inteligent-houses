package cz.cvut.fel.omo.inteligenthouses.console;

/**
 *
 * @author Míša
 */
public class SavingsReport extends Console {

    /**
     * Creates new SavingsReport console
     *
     * @param back parent of this console
     */
    public SavingsReport(Console back) {
        super(savingsReportName, back);
    }

    /**
     * Starts the console
     */
    @Override
    public void start() {
        System.out.println(getLineSeparator());
        System.out.println("Under Construction...");
        
        Init.getInstance().start();
    }

}
