package cz.cvut.fel.omo.inteligenthouses.console;

/**
 * 
 * @author macekja7
 */
public class MenuConfig extends Console {

    /**
     * Creates new MenuConfig console
     * @param back parent of this console
     */
    public MenuConfig(Console back) {
        super(configName, back);
    }

    /**
     * Starts the console
     */
    @Override
    public void start() {
        if (getConsoles().isEmpty()) {
            addConsole(new StaticConfig(this));
        }

        run();
    }

}
