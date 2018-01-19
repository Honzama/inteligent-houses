package cz.cvut.fel.omo.inteligenthouses.simulation.device;

import cz.cvut.fel.omo.inteligenthouses.simulation.TimeFrame;
import cz.cvut.fel.omo.inteligenthouses.simulation.device.state.Active;
import cz.cvut.fel.omo.inteligenthouses.simulation.device.state.Idle;
import cz.cvut.fel.omo.inteligenthouses.simulation.device.state.Off;
import cz.cvut.fel.omo.inteligenthouses.simulation.position.House;
import cz.cvut.fel.omo.inteligenthouses.simulation.position.Outside;
import cz.cvut.fel.omo.inteligenthouses.simulation.position.Position;
import cz.cvut.fel.omo.inteligenthouses.simulation.specimen.Person;
import cz.cvut.fel.omo.inteligenthouses.simulation.specimen.strategy.Strategy;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 *
 * @author kahoumic
 */
public class EquipmentTest {
    
    public EquipmentTest() {
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
    public void getPositionTest_positionNotChanged() {
        String name = "name";
        Position position = new House("addr");
        Equipment equipment = new Equipment(name, position);
        
        assertEquals(position, equipment.getPosition());
    }
    
    @Test
    public void getPositionTest_userWithDifferentPositionSet() {
        String name = "name";
        Position position = new House("addr");
        Equipment equipment = new Equipment(name, position);
        
        String name2 = "name2";
        Position position2 = Outside.getInstance();
        Strategy strategy = new Strategy(new TimeFrame(45, TimeUnit.SECONDS));
        Person person = new Person(name2, position2, strategy);
        
        assertEquals(position, equipment.getPosition());
        
        equipment.setUser(person);
        
        assertEquals(position2, equipment.getPosition());
    }
    
    @Test
    public void defaultStateOffTest() {
        String name = "name";
        Position position = new House("addr");
        Equipment equipment = new Equipment(name, position);
        
        assertTrue(equipment.getState() instanceof Off);
    }
    
    @Test
    public void turnOnTest() {
        String name = "name";
        Position position = new House("addr");
        Equipment equipment = new Equipment(name, position);
        
        assertTrue(equipment.getState() instanceof Off);
        
        equipment.turnOn();
        
        assertTrue(equipment.getState() instanceof Idle);
    }
    
    @Test
    public void turnOffTest() {
        String name = "name";
        Position position = new House("addr");
        Equipment equipment = new Equipment(name, position);
        
        assertTrue(equipment.getState() instanceof Off);
        
        equipment.turnOn();
        
        assertTrue(equipment.getState() instanceof Idle);
        
        equipment.turnOff();
        
        assertTrue(equipment.getState() instanceof Off);
    }
    
    @Test
    public void turnActiveTest() {
        String name = "name";
        Position position = new House("addr");
        Equipment equipment = new Equipment(name, position);
        
        assertTrue(equipment.getState() instanceof Off);
        
        equipment.turnActive();
        
        assertTrue(equipment.getState() instanceof Active);
    }
    
    @Test
    public void turnDeactiveTest() {
        String name = "name";
        Position position = new House("addr");
        Equipment equipment = new Equipment(name, position);
        
        assertTrue(equipment.getState() instanceof Off);
        
        equipment.turnDeactive();
        
        assertTrue(equipment.getState() instanceof Idle);
    }
    
    @Test
    public void turnRepairTest() {
        String name = "name";
        Position position = new House("addr");
        Equipment equipment = new Equipment(name, position);
        
        assertTrue(equipment.getState() instanceof Off);
        
        equipment.turnOn();
        
        assertTrue(equipment.getState() instanceof Idle);
        
        equipment.turnRepair();
        
        assertTrue(equipment.getState() instanceof Off);
    }
    
    @Test
    public void rollbackStateTest() {
        String name = "name";
        Position position = new House("addr");
        Equipment equipment = new Equipment(name, position);
        
        assertTrue(equipment.getState() instanceof Off);
        
        equipment.turnOn();
        assertTrue(equipment.getState() instanceof Idle);
        
        equipment.turnActive();
        assertTrue(equipment.getState() instanceof Active);
        
        equipment.rollbackState();
        assertTrue(equipment.getState() instanceof Idle);
    }
}
