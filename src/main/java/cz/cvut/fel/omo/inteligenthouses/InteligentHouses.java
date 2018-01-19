package cz.cvut.fel.omo.inteligenthouses;

import cz.cvut.fel.omo.inteligenthouses.factory.*;

/**
 *
 * @author macekja7
 */
public class InteligentHouses {

    public static void main(String[] args) {
        ConsoleFactory.getInstance().createInit().setConfig(ConfigFactory.getInstance().createStaticConfig());
        ConsoleFactory.getInstance().createInit().start();
    }
}
