package cz.cvut.fel.omo.inteligenthouses.simulation.specimen;

import cz.cvut.fel.omo.inteligenthouses.simulation.device.Device;
import cz.cvut.fel.omo.inteligenthouses.simulation.position.*;
import cz.cvut.fel.omo.inteligenthouses.simulation.specimen.strategy.Strategy;

/**
 * Abstract class representing a speciman
 *
 * @author macekja7
 */
public abstract class Specimen {

    private String name;
    private Position defaultPosition;
    private Position actualPosition;
    private Strategy strategy;
    private Device using;
    private int timeout;

    /**
     * Creates new Speciman
     *
     * @param name name of the speciman
     * @param position position of the speciman in the house (or outside)
     * @param strategy strategy of the speciman
     */
    public Specimen(String name, Position position, Strategy strategy) {
        this.name = name;
        defaultPosition = position;
        actualPosition = position;
        this.strategy = strategy;
        timeout = 0;
    }

    public String getName() {
        return name;
    }

    public Position getDefaultPosition() {
        return defaultPosition;
    }

    public Position getActualPosition() {
        return actualPosition;
    }

    public Strategy getStrategy() {
        return strategy;
    }

    public Device getUsing() {
        return using;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDefaultPosition(Position position) {
        this.defaultPosition = position;
    }

    public void setActualPosition(Position position) {
        this.actualPosition = position;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    /**
     * Sets given device to the person's using device
     *
     * @param using
     * @param timeout
     */
    public void setUsing(Device using, int timeout) {
        removeUsing();
        addUsing(using);
        this.timeout = timeout;
    }

    public void addUsing(Device using) {
        using.setUser(this);
        this.using = using;
    }

    /**
     * Removes given device from this person's using device
     */
    public void removeUsing() {
        if (using != null) {
            using.setUser(null);
        }
        using = null;
        timeout = 0;
    }

    /**
     * Checks if the speciman should still use device after given time
     *
     * @param time
     */
    public void update(int time) {
        if (timeout - time < 0) {
            if (using != null) {
                removeUsing();
            }
        } else {
            timeout = timeout - time;
        }
    }

    public String toString() {
        if (defaultPosition != actualPosition) {
            if (using != null) {
                return name + " from (" + defaultPosition + ") in (" + actualPosition + ") using " + using + " for " + timeout + " hours " + strategy;
            }
            return name + " from (" + defaultPosition + ") in (" + actualPosition + ") " + strategy;

        } else {
            if (using != null) {
                return name + " in (" + actualPosition + ") using " + using + " for " + timeout + " hours " + strategy;
            }
            return name + " in (" + actualPosition + ") " + strategy;
        }
    }
}
