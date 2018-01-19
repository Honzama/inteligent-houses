package cz.cvut.fel.omo.inteligenthouses.console;

import cz.cvut.fel.omo.inteligenthouses.factory.ConfigFactory;

/**
 *
 * @author macekja7
 */
public class StaticConfig extends Console {

    /**
     * Creates new StaticConfig console
     * @param back parent of this console
     */
    public StaticConfig(Console back) {
        super(staticConfigName, back);
    }

    /**
     * Starts the console with given configs
     */
    @Override
    public void start() {
        System.out.println(getLineSeparator());

        Init.getInstance().setConfig(ConfigFactory.getInstance().createStaticConfig());
        System.out.println("Static Config loaded.");

        Init.getInstance().start();
    }

}
