package cz.cvut.fel.omo.inteligenthouses.simulation.specimen;

import cz.cvut.fel.omo.inteligenthouses.simulation.position.Position;
import cz.cvut.fel.omo.inteligenthouses.simulation.specimen.strategy.Strategy;

/**
 * Represents a single animal
 *
 * @author macekja7
 */
public class Animal extends Specimen {

    /**
     * Creates an Animal
     *
     * @param name name of the animal
     * @param position position of the animal in the house (or outside)
     * @param strategy strategy of the animal
     */
    public Animal(String name, Position position, Strategy strategy) {
        super(name, position, strategy);
    }

}
