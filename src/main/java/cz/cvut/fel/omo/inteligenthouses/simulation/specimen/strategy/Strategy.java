package cz.cvut.fel.omo.inteligenthouses.simulation.specimen.strategy;

import java.util.Random;

import cz.cvut.fel.omo.inteligenthouses.simulation.TimeFrame;

/**
 * Represents a strategy 
 * @author macekja7
 */
public class Strategy {

    private TimeFrame timeFrame;
    private int bottomLine;
    private int upperLine;

    /**
     * Creates a strategy of a speciman
     * @param timeFrame time period of the simulation
     */
    public Strategy(TimeFrame timeFrame) {
        this.timeFrame = timeFrame;
        this.bottomLine = (int)Math.round(timeFrame.getCycle() * (generateRandom(2.5, 4.0) / (10.0)));
        this.upperLine = (int)Math.round(bottomLine + timeFrame.getCycle() * 0.5);
    }

    public TimeFrame getTimeFrame() {
        return timeFrame;
    }

    public void setTimeFrame(TimeFrame timeFrame) {
        this.timeFrame = timeFrame;
    }

    private double generateRandom(double min, double max) {
        Random r = new Random();
        return (r.nextInt((int) ((max - min) * 10 + 1)) + min * 10) / 10.0;
    }

    public boolean isOutside(int state) {
        return state < this.upperLine && state > this.bottomLine;
    }
    
    public String toString() {
    	return "is outside between "+bottomLine+" and "+upperLine+" every day";
    }

}
