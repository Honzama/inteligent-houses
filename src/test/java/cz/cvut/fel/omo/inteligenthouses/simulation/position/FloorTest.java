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
public class FloorTest {
    
    public FloorTest() {
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
    public void addRoomTest() {
        Room room = new Room("room");
        Floor floor = new Floor(5);
        
        assertNotNull(floor.getRooms());
        assertTrue(floor.getRooms().isEmpty());
        assertNull(room.getFloor());
        
        floor.addRoom(room);
        
        assertFalse(floor.getRooms().isEmpty());
        assertEquals(floor, room.getFloor());
    }
    
    @Test 
    public void removeRoomTest() {
        Room room = new Room("room");
        Floor floor = new Floor(5);
        
        floor.addRoom(room);
        
        assertFalse(floor.getRooms().isEmpty());
        
        floor.removeRoom(room);
        
        assertTrue(floor.getRooms().isEmpty());
        assertNull(room.getFloor());
    }
}
