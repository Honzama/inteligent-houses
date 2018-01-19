package cz.cvut.fel.omo.inteligenthouses.console;

/**
 * 
 * @author macekja7
 */
public class IterateSimulation extends Console {

    /**
     * Creates new IterateSimulation console
     * @param back parent of this console
     */
    public IterateSimulation(Console back) {
        super(iterateSimulationName, back);
    }

    /**
     * Loads an input and then runs console
     */
    @Override
    public void start() {
    	System.out.println(getLineSeparator());
        System.out.println(iterateMsg);
        
        int iterations = 0;
        while (iterations == 0) {
            try {
                iterations = Integer.parseInt(loadInput());
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
        
        System.out.println(getLineSeparator());
        Init.getInstance().getConfig().iterateSimulation(iterations);

        getBack().run();
    }

}
