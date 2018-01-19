package cz.cvut.fel.omo.inteligenthouses.factory;

import cz.cvut.fel.omo.inteligenthouses.simulation.TimeFrame;
import cz.cvut.fel.omo.inteligenthouses.simulation.position.Position;
import cz.cvut.fel.omo.inteligenthouses.simulation.specimen.*;
import cz.cvut.fel.omo.inteligenthouses.simulation.specimen.strategy.Strategy;

/**
 *
 * @author macekja7
 */
public class SpecimenFactory extends Factory {

    private static SpecimenFactory instance = null;
    
    private SpecimenFactory() {}

    public Person createPerson(String name, Position position, Strategy strategy) {
        return new Person(name, position, strategy);
    }

    public Animal createAnimal(String name, Position position, Strategy strategy) {
        return new Animal(name, position, strategy);
    }

    public Strategy createStrategy(TimeFrame timeFrame) {
        return new Strategy(timeFrame);
    }

    public static SpecimenFactory getInstance() {
        if (instance == null) {
            instance = new SpecimenFactory();
        }
        return instance;
    }
}
