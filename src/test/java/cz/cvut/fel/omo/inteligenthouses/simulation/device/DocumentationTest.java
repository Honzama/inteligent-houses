package cz.cvut.fel.omo.inteligenthouses.simulation.device;

import java.net.MalformedURLException;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author kahoumic
 */
public class DocumentationTest {
    
    public DocumentationTest() {
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

    @Test(expected = MalformedURLException.class)
    public void setURLTest_invalidURL_MalformedURLException() throws MalformedURLException {
        String name = "doc";
        String url = "...";
        Documentation documentation = new Documentation(name, url);
    }
    
    @Test
    public void setURLTest_validURL() throws MalformedURLException {
        String name = "doc";
        String url = "http://url.com";
        Documentation documentation = new Documentation(name, url);
        assertNotNull(documentation);
        assertEquals(name, documentation.getName());
        assertEquals(url, documentation.getURL().toString());
    }
}
