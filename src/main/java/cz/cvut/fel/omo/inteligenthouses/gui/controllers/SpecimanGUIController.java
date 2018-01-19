package cz.cvut.fel.omo.inteligenthouses.gui.controllers;

import cz.cvut.fel.omo.inteligenthouses.simulation.device.Machine;
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
public class SpecimanGUIController {

    public static String getSpecimanSpecies(Specimen s) {
        return s == null ? null : s.getClass().getSimpleName();
    }

    public static String getSpecimanName(Specimen s) {
        return s == null ? null : s.getName();
    }

    public static String getSpecimanPosition(Specimen s) {
        return s == null ? null : s.getActualPosition().getAddress();
    }

    public static List<Machine> getMachines(Position position) {
        //TODO return machines only a on given position
        List<Machine> mm = new ArrayList<>();
        mm.add(new Machine("trouba", new House("kuchyn"), null));
        mm.add(new Machine("pracka", new House("koupelna"), null));
        mm.add(new Machine("lednice", new House("kuchyn"), null));
        return mm;
    }

    public static List<Specimen> getSpecimen(Specimen speciman) {
        //TODO return specimen only a on given position and except for this speciman
        List<Specimen> ss = new ArrayList<>();
//        ss.add(new Animal("Alik", new House("doma")));
//        ss.add(new Person("Petr", new Outside("venku")));
//        ss.add(new Animal("Julca", new Outside("jinde venku")));
        return ss;
    }

    public static List<Position> getPositions(Position position) {
        //TODO return all positions except for this one
        List<Position> pp = new ArrayList<>();
        pp.add(new House("doma"));
        pp.add(Outside.getInstance());
        return pp;
    }

    public static void changePosition(Specimen speciman, Position newPosition) {
        //TODO actually change position of a speciman!
        speciman.setActualPosition(newPosition);
    }
}
