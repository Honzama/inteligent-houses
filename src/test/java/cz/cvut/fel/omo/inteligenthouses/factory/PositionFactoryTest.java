package cz.cvut.fel.omo.inteligenthouses.factory;

import cz.cvut.fel.omo.inteligenthouses.simulation.position.House;
import cz.cvut.fel.omo.inteligenthouses.simulation.position.Outside;
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
public class PositionFactoryTest {
    
    public PositionFactoryTest() {
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
        PositionFactory pf = PositionFactory.getInstance();
        assertNotNull(pf);
    }
    
    @Test
    public void getOutsideTest_cannotBeNull_originalState() {
        PositionFactory pf = PositionFactory.getInstance();
        Outside outside = pf.getOutside();
        assertNotNull(outside);
    }
    
    @Test
    public void createHouseTest_cannotBeNull_originalState() {
        PositionFactory pf = PositionFactory.getInstance();
        String address = "address";
        House house = pf.createHouse(address);
        assertNotNull(house);
        assertEquals(address, house.getAddress());
    }
            
}
