package cz.cvut.fel.omo.inteligenthouses.factory;

import cz.cvut.fel.omo.inteligenthouses.simulation.device.consumption.Electricity;
import cz.cvut.fel.omo.inteligenthouses.simulation.device.consumption.Water;
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
public class ConsuptionFactoryTest {

    public ConsuptionFactoryTest() {
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
        ConsumptionFactory cf = ConsumptionFactory.getInstance();
        assertNotNull(cf);
    }
    
    @Test
    public void createElectricityTest_createsCorrectElectricity_originalState() {
        ConsumptionFactory cf = ConsumptionFactory.getInstance();
        double idle = 16.0;
        double active = 80.95;
        Electricity electricity = cf.createElectricity(idle, active);
        assertTrue(idle == electricity.getIdle());
        assertTrue(active == electricity.getActive());
    }
    
    @Test
    public void createWaterTest_createsCorrectWater_originalState() {
        ConsumptionFactory cf = ConsumptionFactory.getInstance();
        double idle = 2.0;
        double active = 99.9;
        Water water = cf.createWater(idle, active);
        assertTrue(idle == water.getIdle());
        assertTrue(active == water.getActive());
    }
    
    
}
