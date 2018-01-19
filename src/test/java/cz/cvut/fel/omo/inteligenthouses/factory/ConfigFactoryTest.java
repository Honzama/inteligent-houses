package cz.cvut.fel.omo.inteligenthouses.factory;

import cz.cvut.fel.omo.inteligenthouses.simulation.TimeFrame;
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
public class ConfigFactoryTest {

    public ConfigFactoryTest() {
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
        ConfigFactory cf = ConfigFactory.getInstance();
        assertNotNull(cf);
    }
    
    @Test
    public void createTimeFrameTest_createsCorrectTimeFrame_originalState() {
        int cycle = 3;
        TimeUnit sourceUnits = TimeUnit.SECONDS;
        
        ConfigFactory cf = ConfigFactory.getInstance();
        TimeFrame tf = cf.createTimeFrame(cycle, sourceUnits);
        
        assertTrue(cycle == tf.getCycle());
        assertEquals(sourceUnits, tf.getSourceUnits());
    }
}
