package cz.cvut.fel.omo.inteligenthouses.factory;

import cz.cvut.fel.omo.inteligenthouses.simulation.TimeFrame;
import cz.cvut.fel.omo.inteligenthouses.simulation.position.House;
import cz.cvut.fel.omo.inteligenthouses.simulation.position.Position;
import cz.cvut.fel.omo.inteligenthouses.simulation.specimen.Animal;
import cz.cvut.fel.omo.inteligenthouses.simulation.specimen.Person;
import cz.cvut.fel.omo.inteligenthouses.simulation.specimen.strategy.Strategy;
import java.util.concurrent.TimeUnit;
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
public class SpecimenFactoryTest {
    
    public SpecimenFactoryTest() {
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
    public void getInstanceTest_cannotBeNull_originalState() {
        SpecimenFactory sf = SpecimenFactory.getInstance();
        assertNotNull(sf);
    }
    
    @Test
    public void createPersonTest_cannotBeNull_originalState() {
        SpecimenFactory sf = SpecimenFactory.getInstance();
        String name = "person";
        Position position = new House("addr");
        Strategy strategy = new Strategy(new TimeFrame(20, TimeUnit.SECONDS));
        Person person = sf.createPerson(name, position, strategy);
        assertNotNull(person);
        assertEquals(name, person.getName());
        assertEquals(position, person.getActualPosition());
        assertEquals(strategy, person.getStrategy());
    }
    
    @Test
    public void createAnimalTest_cannotBeNull_originalState() {
        SpecimenFactory sf = SpecimenFactory.getInstance();
        String name = "animal";
        Position position = new House("addr");
        Strategy strategy = new Strategy(new TimeFrame(20, TimeUnit.SECONDS));
        Animal animal = sf.createAnimal(name, position, strategy);
        assertNotNull(animal);
        assertEquals(name, animal.getName());
        assertEquals(position, animal.getActualPosition());
        assertEquals(strategy, animal.getStrategy());
    }
    
    @Test
    public void createStrategyTest_cannotBeNull_originalState() {
        SpecimenFactory sf = SpecimenFactory.getInstance();
        TimeFrame tf = new TimeFrame(456, TimeUnit.MINUTES);
        Strategy strategy = new Strategy(tf);
        assertNotNull(tf);
        assertEquals(tf, strategy.getTimeFrame());
    }
}
