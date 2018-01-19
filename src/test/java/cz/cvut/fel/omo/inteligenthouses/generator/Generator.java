package cz.cvut.fel.omo.inteligenthouses.generator;

import cz.cvut.fel.omo.inteligenthouses.simulation.TimeFrame;
import cz.cvut.fel.omo.inteligenthouses.simulation.device.Documentation;
import cz.cvut.fel.omo.inteligenthouses.simulation.device.Machine;
import cz.cvut.fel.omo.inteligenthouses.simulation.position.Floor;
import cz.cvut.fel.omo.inteligenthouses.simulation.position.House;
import cz.cvut.fel.omo.inteligenthouses.simulation.position.Outside;
import cz.cvut.fel.omo.inteligenthouses.simulation.specimen.Animal;
import cz.cvut.fel.omo.inteligenthouses.simulation.specimen.Person;
import cz.cvut.fel.omo.inteligenthouses.simulation.specimen.strategy.Strategy;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author kahoumic
 */
public class Generator {
    public static Person generatePerson() {
        return new Person(
                "person_name", 
                new House("address_of_house"), 
                new Strategy(new TimeFrame(5, TimeUnit.MINUTES))
        );
    }
    
    public static Animal generateAnimal() {
        return new Animal(
                "animal_name", 
                Outside.getInstance(), 
                new Strategy(new TimeFrame(90, TimeUnit.MINUTES))
        );
    }
    
    public static Machine generateMachine() throws MalformedURLException {
        return new Machine(
                "machine_name", 
                new House("address_of_house"), 
                new Documentation("documentation_name", "http://documentation.com")
        );
    }
}
