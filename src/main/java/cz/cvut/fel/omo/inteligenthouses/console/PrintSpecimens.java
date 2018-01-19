package cz.cvut.fel.omo.inteligenthouses.console;

import cz.cvut.fel.omo.inteligenthouses.simulation.specimen.Specimen;

/**
 *
 * @author macekja7
 */
public class PrintSpecimens extends Console {

    /**
     * Creates new PrintSpecimens console
     * @param back parent of this console
     */
    public PrintSpecimens(Console back) {
        super(printSpecimensName, back);
    }

    /**
     * Starts the console
     */
    @Override
    public void start() {
        System.out.println(getLineSeparator());
        System.out.println("Number of active specimens in simulation: " + Init.getInstance().getConfig().getSpecimens().size() + "\r\n");

        for (Specimen s : Init.getInstance().getConfig().getSpecimens()) {
            System.out.println("- " + s);
        }

        getBack().run();
    }

}
