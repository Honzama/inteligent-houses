package cz.cvut.fel.omo.inteligenthouses.simulation.position;

import cz.cvut.fel.omo.inteligenthouses.generator.Generator;
import cz.cvut.fel.omo.inteligenthouses.simulation.device.Device;
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
public class RoomTest {
    
    public RoomTest() {
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
    public void addDeviceTest() throws MalformedURLException {
        Device device = Generator.generateMachine();
        Room room = new Room("room");
        
        assertNotNull(room.getDevices());
        assertTrue(room.getDevices().isEmpty());
        
        room.addDevice(device);
        
        assertFalse(room.getDevices().isEmpty());
    }
    
    @Test 
    public void removeDeviceTest() throws MalformedURLException {
        Device device = Generator.generateMachine();
        Room room = new Room("room");
        
        room.addDevice(device);
        
        assertFalse(room.getDevices().isEmpty());
        
        room.removeDevice(device);
        
        assertTrue(room.getDevices().isEmpty());
        //assertNull(device.getPosition());
    }
}
