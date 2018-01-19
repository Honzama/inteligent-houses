package cz.cvut.fel.omo.inteligenthouses.factory;

import java.net.MalformedURLException;

import cz.cvut.fel.omo.inteligenthouses.simulation.device.*;
import cz.cvut.fel.omo.inteligenthouses.simulation.position.Position;

/**
 *
 * @author macekja7
 */
public class DeviceFactory extends Factory {

    private static DeviceFactory instance = null;
    
    private DeviceFactory() {}

    public Machine createMachine(String name, Position position, Documentation documentation) {
        return new Machine(name, position, documentation);
    }

    public Equipment createEquipment(String name, Position position) {
        return new Equipment(name, position);
    }

    public Documentation createDocumentation(String name, String url) throws MalformedURLException {
        return new Documentation(name, url);
    }

    public Sensor createSensor(String name, double value, double min, double max, String unit) {
        return new Sensor(name, value, min, max, unit);
    }

    public Item createItem(String name) {
        return new Item(name);
    }

    public static DeviceFactory getInstance() {
        if (instance == null) {
            instance = new DeviceFactory();
        }
        return instance;
    }
}
