package cz.cvut.fel.omo.inteligenthouses.simulation.device;

import cz.cvut.fel.omo.inteligenthouses.factory.StateFactory;
import cz.cvut.fel.omo.inteligenthouses.simulation.position.Position;
import cz.cvut.fel.omo.inteligenthouses.simulation.specimen.Person;

/**
 * Represents equipment
 * @author macekja7
 */
public class Equipment extends Device {

    /**
     * Creates new Equipment
     * @param name name of the equipment
     * @param position position of the equiplment in the house (or outside)
     */
    public Equipment(String name, Position position) {
        super(name, position);
    }

    @Override
    public Position getPosition() {
        if (getUser() != null) {
            return getUser().getActualPosition();
        }
        return super.getPosition();
    }

    public void setUser(Person user) {
        super.setUser(user);
        if (getUser() != null) {
            this.setState(StateFactory.getInstance().createActive());
        } else {
            this.setState(StateFactory.getInstance().createOff());
        }
    }
}
