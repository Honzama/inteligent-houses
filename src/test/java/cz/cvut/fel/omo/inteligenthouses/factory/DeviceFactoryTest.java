package cz.cvut.fel.omo.inteligenthouses.factory;

import cz.cvut.fel.omo.inteligenthouses.simulation.device.Documentation;
import cz.cvut.fel.omo.inteligenthouses.simulation.device.Equipment;
import cz.cvut.fel.omo.inteligenthouses.simulation.device.Item;
import cz.cvut.fel.omo.inteligenthouses.simulation.device.Machine;
import cz.cvut.fel.omo.inteligenthouses.simulation.device.Sensor;
import cz.cvut.fel.omo.inteligenthouses.simulation.position.House;
import cz.cvut.fel.omo.inteligenthouses.simulation.position.Position;
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
public class DeviceFactoryTest {

    public DeviceFactoryTest() {
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
        DeviceFactory df = DeviceFactory.getInstance();
        assertNotNull(df);
    }
    
    @Test
    public void createMachineTest_createsCorrectMachine_originalState() throws MalformedURLException {
        DeviceFactory df = DeviceFactory.getInstance();
        String name = "name";
        Position position = new House("address");
        Documentation documentation = new Documentation("name", "http://www.url.com");
        Machine machine = df.createMachine(name, position, documentation);
        assertEquals(name, machine.getName());
        assertEquals(position, machine.getPosition());
        assertEquals(documentation, machine.getDocumentation());
    }
    
    @Test
    public void createEquipmentTest_createsCorrectEquipment_originalState() {
        DeviceFactory df = DeviceFactory.getInstance();
        String name = "equipment";
        Position position = new House("house");
        Equipment equipment = df.createEquipment(name, position);
        assertEquals(name, equipment.getName());
        assertEquals(position, equipment.getPosition());
    }
    
    @Test
    public void createDocumentationTest_createsCorrectDocumentation_originalState() throws MalformedURLException {
        DeviceFactory df = DeviceFactory.getInstance();
        String name = "documentation";
        String url = "http://www.url.com";
        Documentation documentation = df.createDocumentation(name, url);
        assertEquals(name, documentation.getName());
        assertEquals(url, documentation.getURL().toString());
    }
    
    @Test
    public void createSensorTest_createsCorrectSensor_originalState() {
        DeviceFactory df = DeviceFactory.getInstance();
        String name = "sensor";
        double value = 2.3;
        double min = 1.3;
        double max = 5.2;
        String unit = "unit";
        Sensor sensor = df.createSensor(name, value, min, max, unit);
        assertEquals(name, sensor.getName());
        assertTrue(value == sensor.getValue());
        assertTrue(min == sensor.getMin());
        assertTrue(max == sensor.getMax());
        assertEquals(unit, sensor.getUnit());
    }
    
    @Test
    public void createItemTest_createsCorrectItem_originalState() {
        DeviceFactory df = DeviceFactory.getInstance();
        String name = "item";
        Item item = df.createItem(name);
        assertEquals(name, item.getName());
    }
}
