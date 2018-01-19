package cz.cvut.fel.omo.inteligenthouses.simulation.position;

import java.util.ArrayList;
import java.util.List;

import cz.cvut.fel.omo.inteligenthouses.simulation.specimen.Person;

/**
 * Represents outside
 * @author macekja7
 */
public class Outside extends Position {

    private static Outside instance = null;
    public List<Person> people;

    private Outside(String adress) {
        super(adress);
        people = new ArrayList<Person>();
    }

    public List<Person> getPeople() {
        return people;
    }

    public void setPeople(List<Person> people) {
        this.people = people;
    }

    /**
     * Adds given person to the list of this house's people; sets outside as actual position of the person
     * @param person
     * @return <code>true</code> if add successful
     */
    public boolean addPerson(Person person) {
        person.setActualPosition(this);
        return people.add(person);
    }

    /**
     * Removes given person from the list of this house's people; sets default position as actual position of the person
     * @param person
     * @return <code>true</code> if add successful
     */
    public boolean removePerson(Person person) {
        person.setActualPosition(person.getDefaultPosition());
        return people.remove(person);
    }

    /**
     * Removes every person from outside and sets his actual position to his default position
     */
    public void clear() {
        if (!people.isEmpty()) {
            people.forEach(p -> p.setActualPosition(p.getDefaultPosition()));
        }
        people.clear();
    }

    public static Outside getInstance() {
        if (instance == null) {
            instance = new Outside("Outside");
        }
        return instance;
    }

}
