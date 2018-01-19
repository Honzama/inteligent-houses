package cz.cvut.fel.omo.inteligenthouses.simulation.event;

import cz.cvut.fel.omo.inteligenthouses.simulation.TimeFrame;
import cz.cvut.fel.omo.inteligenthouses.simulation.device.Device;
import cz.cvut.fel.omo.inteligenthouses.simulation.device.Documentation;
import cz.cvut.fel.omo.inteligenthouses.simulation.device.Machine;
import cz.cvut.fel.omo.inteligenthouses.simulation.event.Alert;
import cz.cvut.fel.omo.inteligenthouses.simulation.position.House;
import cz.cvut.fel.omo.inteligenthouses.simulation.position.Outside;
import cz.cvut.fel.omo.inteligenthouses.simulation.specimen.Animal;
import cz.cvut.fel.omo.inteligenthouses.simulation.specimen.Specimen;
import cz.cvut.fel.omo.inteligenthouses.simulation.specimen.strategy.Strategy;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

/**
 *
 * @author kahoumic
 */
public class AlertTest {

    Animal animal;
    Machine machine;

    public AlertTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws MalformedURLException {
        animal = new Animal("animal", Outside.getInstance(), new Strategy(new TimeFrame(44, TimeUnit.SECONDS)));
        machine = new Machine("machine", new House("addr"), new Documentation("doc", "http://doc.com"));
    }

    @After
    public void tearDown() {
    }

    @Test
    public void createAlertTest_inputTypeInstanceOfSpecimen() {
        Alert alert = new Alert(animal);

        Object input = alert.getInput();
        assertTrue(input instanceof Specimen);
    }

    @Test
    public void createAlertTest_inputTypeInstanceOfDevice() {
        Alert alert = new Alert(machine);

        Object input = alert.getInput();
        assertTrue(input instanceof Device);
    }
}
