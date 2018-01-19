package cz.cvut.fel.omo.inteligenthouses.simulation.device;

/**
 * Represents a sensor
 * @author macekja7
 */
public class Sensor {

    private String name;
    private Machine machine;
    private double value;
    private double max;
    private double min;
    private String unit;

    /**
     * Creates new Sensor
     * @param name name of the sensor
     * @param value value of the sensor
     * @param min min value of the sensor
     * @param max max value of the sensor
     * @param unit unit of the sensor
     */
    public Sensor(String name, double value, double min, double max, String unit) {
        this.name = name;
        machine = null;
        this.value = value;
        this.min = min;
        this.max = max;
        this.unit = unit;
    }

    public String getName() {
        return name;
    }

    public Machine getMachine() {
        return machine;
    }

    public double getValue() {
        return value;
    }

    public double getMax() {
        return max;
    }

    public double getMin() {
        return min;
    }

    public String getUnit() {
        return unit;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMachine(Machine machine) {
        this.machine = machine;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void setMax(double max) {
        this.max = max;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
    
    public String toString() {
    	return name+" from "+machine.getName()+" with "+value+" "+unit;
    }
}
