package cz.cvut.fel.omo.inteligenthouses.console;

/**
 *
 * @author macekja7
 */
public class Simulation extends Console {

    /**
     * Creates new Simulation console
     * @param back parent of this console
     */
    public Simulation(Console back) {
        super(simulationName, back);
    }

    /** 
     * Starts the console and adds every print console under it
     */
    @Override
    public void start() {
    	if(getConsoles().isEmpty()) {
    		addConsole(new IterateSimulation(this));
            addConsole(new PrintDevices(this));
            addConsole(new PrintEvents(this));
            addConsole(new PrintHouses(this));
            addConsole(new PrintSpecimens(this));
    	}
        
        run();
    }

}
