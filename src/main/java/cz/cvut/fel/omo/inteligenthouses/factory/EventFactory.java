package cz.cvut.fel.omo.inteligenthouses.factory;

import cz.cvut.fel.omo.inteligenthouses.simulation.device.Device;
import cz.cvut.fel.omo.inteligenthouses.simulation.event.*;
import cz.cvut.fel.omo.inteligenthouses.simulation.specimen.Specimen;

/**
 *
 * @author macekja7
 */
public class EventFactory extends Factory {

    private static EventFactory instance;
    
    private EventFactory() {}

    public Alert createAlert(Specimen specimen) {
        return new Alert(specimen);
    }

    public Alert createAlert(Device device) {
        return new Alert(device);
    }

    public Info createInfo(Specimen specimen, Device device) {
        return new Info(specimen, device);
    }

    public Info createInfo(Device device, Specimen specimen) {
        return new Info(device, specimen);
    }

    public EventHandler createEventHandler() {
        return new EventHandler();
    }

    public static EventFactory getInstance() {
        if (instance == null) {
            instance = new EventFactory();
        }
        return instance;
    }
}
