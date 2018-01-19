package cz.cvut.fel.omo.inteligenthouses.factory;

import cz.cvut.fel.omo.inteligenthouses.simulation.TimeFrame;
import cz.cvut.fel.omo.inteligenthouses.simulation.device.Device;
import cz.cvut.fel.omo.inteligenthouses.simulation.device.Documentation;
import cz.cvut.fel.omo.inteligenthouses.simulation.device.Machine;
import cz.cvut.fel.omo.inteligenthouses.simulation.event.Alert;
import cz.cvut.fel.omo.inteligenthouses.simulation.event.Info;
import cz.cvut.fel.omo.inteligenthouses.simulation.position.House;
import cz.cvut.fel.omo.inteligenthouses.simulation.position.Outside;
import cz.cvut.fel.omo.inteligenthouses.simulation.specimen.Animal;
import cz.cvut.fel.omo.inteligenthouses.simulation.specimen.strategy.Strategy;
import java.net.MalformedURLException;
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
public class EventFactoryTest {
    
    Animal animal;
    Device machine;
    
    public EventFactoryTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws MalformedURLException {
        animal = new Animal("kitty", new House("addr"), new Strategy(new TimeFrame(5, TimeUnit.SECONDS)));
        machine = new Machine("machine", Outside.getInstance(), new Documentation("dok", "http://dok.com"));
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void getInstanceTest_cannotBeNull_originalState() {
        EventFactory ef = EventFactory.getInstance();
        
        assertNotNull(ef);
    }
    
    @Test
    public void createSpecimanAlertTest_createsCorrectAlert_originalState() {
        EventFactory ef = EventFactory.getInstance();
        Alert alert = ef.createAlert(animal);
        assertNotNull(alert);
        assertEquals(animal, alert.getInput());
    }
    
    @Test
    public void createDeviceAlertTest_createsCorrectAlert_originalState() {
        EventFactory ef = EventFactory.getInstance();
        Alert alert = ef.createAlert(machine);
        assertNotNull(alert);
        assertEquals(machine, alert.getInput());
        
    }
    
    @Test
    public void createSpecimanInfoTest_createsCorrectInfo_originalState() {
        EventFactory ef = EventFactory.getInstance();
        Info info = ef.createInfo(animal, machine);
        assertNotNull(info);
        assertEquals(animal, info.getInput());
        assertEquals(machine, info.getOutput());
        
    }
    
    @Test
    public void createDeviceInfoTest_createsCorrectInfo_originalState() {
        EventFactory ef = EventFactory.getInstance();
        Info info = ef.createInfo(machine, animal);
        assertNotNull(info);
        assertEquals(machine, info.getInput());
        assertEquals(animal, info.getOutput());
        
    }
}
