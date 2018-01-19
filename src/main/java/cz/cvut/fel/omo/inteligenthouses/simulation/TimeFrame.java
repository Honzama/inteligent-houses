package cz.cvut.fel.omo.inteligenthouses.simulation;

import java.util.concurrent.TimeUnit;

/**
 * Respresents a time period for the simulation.
 * @author macekja7
 */
public class TimeFrame {

    private int cycle;
    private TimeUnit sourceUnits;

    /**
     * Creates new TimeFrame
     * @param cycle number of cycles
     * @param sourceUnits time units
     */
    public TimeFrame(int cycle, TimeUnit sourceUnits) {
        this.cycle = cycle;
        this.sourceUnits = sourceUnits;
    }

    public int getCycle() {
        return cycle;
    }

    public TimeUnit getSourceUnits() {
        return sourceUnits;
    }

    public void setCycle(int cycle) {
        this.cycle = cycle;
    }

    public void setSourceUnits(TimeUnit sourceUnits) {
        this.sourceUnits = sourceUnits;
    }

}
