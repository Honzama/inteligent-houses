package cz.cvut.fel.omo.inteligenthouses.simulation.device;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * Represents a documentation of a device
 * @author macekja7
 */
public class Documentation {

    private String name;
    private URL url;

    /**
     * 
     * @param name name of the documentation
     * @param url in valid format so a newURL(url) can be created
     * @throws MalformedURLException when url is not in valid format
     */
    public Documentation(String name, String url) throws MalformedURLException {
        this.name = name;
        this.url = new URL(url);
    }

    public String getName() {
        return name;
    }

    public URL getURL() {
        return url;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setURL(String url) throws MalformedURLException {
        this.url = new URL(url);
    }

    /**
     * Loads a documentation from it's URL
     * @return File of Documentation
     * @throws IOException if loading is not successful
     */
    public File loadDocumentation() throws IOException {
        InputStream in = url.openStream();

        Files.copy(in, Paths.get(name + ".pdf"), StandardCopyOption.REPLACE_EXISTING);

        in.close();
        return Paths.get(name + ".pdf").toFile();
    }

    /**
     * Deletes a documentation
     * @return <code>true</code> iff successful
     */
    public boolean unloadDocumentation() {
        return Paths.get(name + ".pdf").toFile().delete();
    }
}
