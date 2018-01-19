package cz.cvut.fel.omo.inteligenthouses.simulation.position;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author kahoumic
 */
public class HouseTest {
    
    public HouseTest() {
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
    public void addFloorTest() {
        Floor floor = new Floor(5);
        House house = new House("address");
        
        assertNotNull(house.getFloors());
        assertTrue(house.getFloors().isEmpty());
        assertNull(floor.getHouse());
        
        house.addFloor(floor);
        
        assertFalse(house.getFloors().isEmpty());
        assertEquals(house, floor.getHouse());
    }
    
    @Test 
    public void removeFloorTest() {
        Floor floor = new Floor(5);
        House house = new House("address");
        
        house.addFloor(floor);
        
        assertFalse(house.getFloors().isEmpty());
        
        house.removeFloor(floor);
        
        assertTrue(house.getFloors().isEmpty());
        assertNull(floor.getHouse());
    }
}
