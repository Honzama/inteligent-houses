package cz.cvut.fel.omo.inteligenthouses.factory;

import cz.cvut.fel.omo.inteligenthouses.console.*;

/**
 *
 * @author macekja7
 */
public class ConsoleFactory {

    private static ConsoleFactory instance = null;

    private ConsoleFactory() {
    }

    public Init createInit() {
        return Init.getInstance();
    }

    public static ConsoleFactory getInstance() {
        if (instance == null) {
            instance = new ConsoleFactory();
        }
        return instance;
    }
}
