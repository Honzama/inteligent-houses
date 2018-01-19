package cz.cvut.fel.omo.inteligenthouses.simulation.event;

import cz.cvut.fel.omo.inteligenthouses.generator.Generator;
import cz.cvut.fel.omo.inteligenthouses.simulation.device.Device;
import cz.cvut.fel.omo.inteligenthouses.simulation.device.Machine;
import cz.cvut.fel.omo.inteligenthouses.simulation.specimen.Person;
import cz.cvut.fel.omo.inteligenthouses.simulation.specimen.Specimen;
import java.net.MalformedURLException;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author kahoumic
 */
public class InfoTest {
    
    Person person;
    Machine machine;
    
    public InfoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws MalformedURLException {
        person = Generator.generatePerson();
        machine = Generator.generateMachine();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void createInfoTest_deviceInputSpecimanOutput() {
        Info info = new Info(machine, person);
        Object input = info.getInput();
        Object output = info.getOutput();
        
        assertTrue(input instanceof Device);
        assertTrue(output instanceof Specimen);
    }
    
    @Test
    public void createInfoTest_specimanInputDeviceOutput() {
        Info info = new Info(person, machine);
        Object input = info.getInput();
        Object output = info.getOutput();
        
        assertTrue(input instanceof Specimen);
        assertTrue(output instanceof Device);
    }
}
