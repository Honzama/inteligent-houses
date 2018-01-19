package cz.cvut.fel.omo.inteligenthouses.gui.controllers;

import cz.cvut.fel.omo.inteligenthouses.simulation.device.Item;
import cz.cvut.fel.omo.inteligenthouses.simulation.device.Machine;
import cz.cvut.fel.omo.inteligenthouses.simulation.device.Sensor;
import cz.cvut.fel.omo.inteligenthouses.simulation.device.state.Active;
import cz.cvut.fel.omo.inteligenthouses.simulation.device.state.Broken;
import cz.cvut.fel.omo.inteligenthouses.simulation.device.state.Idle;
import cz.cvut.fel.omo.inteligenthouses.simulation.device.state.Off;
import cz.cvut.fel.omo.inteligenthouses.simulation.device.state.State;
import cz.cvut.fel.omo.inteligenthouses.simulation.position.House;
import cz.cvut.fel.omo.inteligenthouses.simulation.position.Outside;
import cz.cvut.fel.omo.inteligenthouses.simulation.position.Position;
import cz.cvut.fel.omo.inteligenthouses.simulation.specimen.Specimen;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kahoumic
 */
public class MachineGUIController {
    public static String getSpecimanName(Specimen s) {
        return s == null ? null : s.getName();
    }
    
    public static String getMachineName(Machine m) {
        return m == null? null : m.getName();
    }

    public static State getMachineState(Machine m) {
        return m == null ? null : m.getState();
    }
    
    public static Position getMachinePosition(Machine m) {
        return m == null ? null : m.getPosition();
    }
    
    
    public static List<Sensor> getSensors(Machine machine) {
        //TODO return correct sensors
        //return machine.getSensors();
        List<Sensor> ss = new ArrayList<>();
        ss.add(new Sensor("sensor1", 12, 0, 20,"Units"));
        ss.add(new Sensor("sensor2", 1, 0, 20,"Units"));
        ss.add(new Sensor("sensor3", 23, 10, 25,"Units"));
        return ss;
    }

    public static List<Item> getItems(Machine machine) {
        //TODO return correct items
        //return machine.getItems();
        List<Item> ii = new ArrayList<>();
        ii.add(new Item("item1"));
        ii.add(new Item("item2"));
        ii.add(new Item("item3"));
        return ii;
    }

    public static List<State> getStates() {
        //TODO return real list of states
        List<State> ss = new ArrayList<>();
        ss.add(new Active());
        ss.add(new Broken());
        ss.add(new Idle());
        ss.add(new Off());
        return ss;
    }

    public static List<Position> getPositions(Position p) {
    //public static List<Position> getPositions() {
        //TODO return real list of positions, with parameter only for fake data
        List<Position> pp = new ArrayList<>();
        pp.add(new House("doma"));
        pp.add(new House("pokoj"));
        pp.add(new House("balkon"));
        pp.add(p);
        pp.add(Outside.getInstance());
        return pp; 
    }
}
