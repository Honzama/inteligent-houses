package cz.cvut.fel.omo.inteligenthouses.factory;

import cz.cvut.fel.omo.inteligenthouses.simulation.device.state.Active;
import cz.cvut.fel.omo.inteligenthouses.simulation.device.state.Broken;
import cz.cvut.fel.omo.inteligenthouses.simulation.device.state.Idle;
import cz.cvut.fel.omo.inteligenthouses.simulation.device.state.Off;
import cz.cvut.fel.omo.inteligenthouses.simulation.device.state.State;
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
public class StateFactoryTest {
    
    public StateFactoryTest() {
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
        StateFactory sf = StateFactory.getInstance();
        assertNotNull(sf);
    }
    
    @Test
    public void createActiveTest_cannotBeNullHasToBeCorrect_originalState() {
        StateFactory sf = StateFactory.getInstance();
        State state = sf.createActive();
        assertNotNull(state);
        assertTrue(state instanceof Active);
    }
    
    @Test
    public void createBrokenTest_cannotBeNullHasToBeCorrect_originalState() {
        StateFactory sf = StateFactory.getInstance();
        State state = sf.createBroken();
        assertNotNull(state);
        assertTrue(state instanceof Broken);
    }
    
    @Test
    public void createIdleTest_cannotBeNullHasToBeCorrect_originalState() {
        StateFactory sf = StateFactory.getInstance();
        State state = sf.createIdle();
        assertNotNull(state);
        assertTrue(state instanceof Idle);
    }
    
    @Test
    public void createOffTest_cannotBeNullHasToBeCorrect_originalState() {
        StateFactory sf = StateFactory.getInstance();
        State state = sf.createOff();
        assertNotNull(state);
        assertTrue(state instanceof Off);
    }
}
