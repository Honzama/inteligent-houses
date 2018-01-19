package cz.cvut.fel.omo.inteligenthouses.simulation.device;

import cz.cvut.fel.omo.inteligenthouses.simulation.position.House;
import java.net.MalformedURLException;
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
public class MachineTest {
    
    public MachineTest() {
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
    public void addSensorTest_sensorsEmptyList() throws MalformedURLException {
        Machine machine = new Machine("name", new House("addr"), new Documentation("doc", "http://doc.com"));
        assertFalse(machine.getSensors() == null);
        assertTrue(machine.getSensors().isEmpty());
    }
    
    @Test
    public void addSensorTest() throws MalformedURLException {
        Machine machine = new Machine("name", new House("addr"), new Documentation("doc", "http://doc.com"));
        String name = "sensor";
        String unit = "unit";
        
        Sensor sensor = new Sensor(name, 5.2, 1.1, 8.9, unit);
        assertNull(sensor.getMachine());
        
        machine.addSensor(sensor);
        assertEquals(sensor, machine.getSensors().get(0));
        assertEquals(machine, sensor.getMachine());
    }
    
    @Test
    public void addItemTest_itemsEmptyList() throws MalformedURLException {
        Machine machine = new Machine("name", new House("addr"), new Documentation("doc", "http://doc.com"));
        assertFalse(machine.getItems() == null);
        assertTrue(machine.getItems().isEmpty());
    }
    
    @Test
    public void addItemTest() throws MalformedURLException {
        Machine machine = new Machine("name", new House("addr"), new Documentation("doc", "http://doc.com"));
        String name = "sensor";
        String unit = "unit";

        Item item = new Item("item");
        assertNull(item.getMachine());
        
        machine.addItem(item);
        assertEquals(item, machine.getItems().get(0));
        assertEquals(machine, item.getMachine());
    }
    
    @Test
    public void removeSensorTest() throws MalformedURLException {
        Machine machine = new Machine("name", new House("addr"), new Documentation("doc", "http://doc.com"));
        String name = "sensor";
        String unit = "unit";
        
        Sensor sensor = new Sensor(name, 5.2, 1.1, 8.9, unit);
        assertNull(sensor.getMachine());
        
        machine.addSensor(sensor);
        assertEquals(sensor, machine.getSensors().get(0));
        assertEquals(machine, sensor.getMachine());
        
        machine.removeSensor(sensor);
        assertTrue(machine.getSensors().isEmpty());
        assertTrue(sensor.getMachine() == null);
    }
    
    @Test
    public void removeItemTest() throws MalformedURLException {
        Machine machine = new Machine("name", new House("addr"), new Documentation("doc", "http://doc.com"));
        String name = "sensor";
        String unit = "unit";
        
        Item item = new Item("item");
        assertNull(item.getMachine());
        
        machine.addItem(item);
        assertEquals(item, machine.getItems().get(0));
        assertEquals(machine, item.getMachine());
        
        machine.removeItem(item);
        assertTrue(machine.getItems().isEmpty());
        assertTrue(item.getMachine() == null);
    }
}
