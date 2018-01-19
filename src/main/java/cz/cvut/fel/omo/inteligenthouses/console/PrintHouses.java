package cz.cvut.fel.omo.inteligenthouses.console;

import cz.cvut.fel.omo.inteligenthouses.simulation.position.House;

/**
 *
 * @author macekja7
 */
public class PrintHouses extends Console {

    /**
     * Creates new PrintHouses console
     * @param back parent of this console
     */
    public PrintHouses(Console back) {
        super(printHousesName, back);
    }

    /**
     * Starts the console
     */
    @Override
    public void start() {
        System.out.println(getLineSeparator());
        System.out.println("Number of houses in simulation: " + Init.getInstance().getConfig().getHouses().size() + "\r\n");

        for (House h : Init.getInstance().getConfig().getHouses()) {
            System.out.println("- " + h + ".");
        }

        getBack().run();
    }

}
