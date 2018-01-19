package cz.cvut.fel.omo.inteligenthouses.simulation.position;

import cz.cvut.fel.omo.inteligenthouses.generator.Generator;
import cz.cvut.fel.omo.inteligenthouses.simulation.specimen.Person;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author kahoumic
 */
public class OutsideTest {

    public OutsideTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void getInstanceTest() {
        Outside outside = Outside.getInstance();
        assertNotNull(outside);
    }

    @Test
    public void addPerson() {
        Outside outside = Outside.getInstance();
        Person person = Generator.generatePerson();
        Position defaultPosition = person.getDefaultPosition();

        assertNotNull(outside.getPeople());

        boolean added = outside.addPerson(person);
        Position actualPosition = person.getActualPosition();

        assertTrue(added);
        assertNotEquals(defaultPosition, actualPosition);
    }

    @Test
    public void removePerson() {
        Outside outside = Outside.getInstance();
        Person person = Generator.generatePerson();
        Position defaultPosition = person.getDefaultPosition();

        assertNotNull(outside.getPeople());

        outside.addPerson(person);
        Position actualPosition = person.getActualPosition();

        assertNotEquals(defaultPosition, actualPosition);

        boolean removed = outside.removePerson(person);

        defaultPosition = person.getDefaultPosition();
        actualPosition = person.getActualPosition();

        assertTrue(removed);
        assertEquals(defaultPosition, actualPosition);
    }

    @Test
    public void clearTest() {
        Outside outside = Outside.getInstance();
        Person person = Generator.generatePerson();
        Position defaultPosition = person.getDefaultPosition();

        outside.addPerson(person);
        outside.clear();
        Position actualPosition = person.getActualPosition();

        assertTrue(outside.getPeople().isEmpty());
        assertEquals(defaultPosition, actualPosition);

    }
}
