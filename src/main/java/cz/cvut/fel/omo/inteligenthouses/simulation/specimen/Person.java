package cz.cvut.fel.omo.inteligenthouses.simulation.specimen;

import cz.cvut.fel.omo.inteligenthouses.simulation.position.Position;
import cz.cvut.fel.omo.inteligenthouses.simulation.specimen.strategy.Strategy;

/**
 * Represents a single person
 *
 * @author macekja7
 */
public class Person extends Specimen {

    /**
     * Creates new Person
     *
     * @param name name of the person
     * @param position position of the person in the house (or outside)
     * @param strategy strategy of the person
     */
    public Person(String name, Position position, Strategy strategy) {
        super(name, position, strategy);
    }
}
