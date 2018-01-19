package cz.cvut.fel.omo.inteligenthouses.console;

import cz.cvut.fel.omo.inteligenthouses.config.Config;

/**
 * Represents a concrete console
 * @author macekja7
 */
public class Init extends Console {

    private static Init instance;
    private Config config;

    private Init() {
        super(initName, null);
        System.out.println(systemName + " " + version + "\r\nBOOTING UP...\r\n");
        System.out.println(welcomeMsg);
    }

    /**
     * Launches a console with given configuration
     */
    @Override
    public void start() {
        if (!containConsole(configName)) {
            addConsole(new MenuConfig(this));
        }
        if (config != null && !containConsole(simulationName) && !containConsole(reportingName)) {
            addConsole(new Simulation(this));
            addConsole(new Reporting(this));
        }

        run();
    }

    /**
     *
     * @return instance of Init
     */
    public static Init getInstance() {
        if (instance == null) {
            instance = new Init();
        }
        return instance;
    }

    public Config getConfig() {
        return config;
    }

    public void setConfig(Config config) {
        this.config = config;
    }

}
